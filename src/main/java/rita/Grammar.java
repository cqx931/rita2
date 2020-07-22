package rita;

import java.util.Map;
import java.util.function.Function;

import com.google.gson.Gson;

public class Grammar {
	
	public static String DEFAULT_RULE_NAME = "start";
	
	protected Map<String, Object> context, rules;
	protected RiScript compiler;

	public Grammar(String rules) {
		this(rules, null);
	}

	public Grammar(String rules, Map<String, Object> context) {
		this(parseJson(rules), context);
	}

	public Grammar(Map<String, Object> rules) {
		this(rules, null);
	}

	public Grammar(Map<String, Object> rules, Map<String, Object> context) {
		this.rules = rules;
		this.context = context;
		this.compiler = new RiScript();
	}
	
	public String expand(String rule) {
		return expand(rule, null);		
	}
	
	public String expand(Map<String, Object> opts) {
		return expand(DEFAULT_RULE_NAME, opts);
	}

	@SuppressWarnings("unchecked")
	public String expand(String rule , Map<String, Object> opts) {

    Map<String, Object> ctx = Util.mergeMaps(this.context, this.rules);
    if (opts != null) {
    	Object val = opts.get("context");
    	if (val != null) {
    		ctx = Util.mergeMaps(ctx, (Map<String, Object>)val);	
    	}
    }
    if (rule.startsWith("$")) rule = rule.substring(1);
    Object o = ctx.get(rule);
    if (o == null) throw new RiTaException("Rule " + rule + " not found");

    return this.compiler.evaluate((String) o, ctx, opts);
  }


	public Grammar setRules(Map<String, Object> rules) {
		this.rules = rules;
		return this;
	}

	public Grammar setRules(String json) {
		this.rules = parseJson(json);
		return this;
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> parseJson(String rules) {
		Gson gson = new Gson();
		Map<String, Object> rmap;
		try {
			return gson.fromJson(rules, Map.class);
		} catch (Exception e) {
			throw new RiTaException("Grammar appears to be invalid JSON"
					+ ", please check it at http://jsonlint.com/\n" + rules);
		}
	}

	public Grammar addRule(String name, String[] rule) {
		return this.addRule(name, joinChoice(rule));
	}

	public Grammar addRule(String name, String rule) {
		if (name.startsWith("$")) name = name.substring(1);
		if (RE.test("\\|", rule) && !RE.test("^\\(.*\\)$", rule)) {
			rule = '(' + rule + ')';
		}
		this.rules.put(name, rule);
		return this;
	}

	private String joinChoice(String[] opts) {
		String res = "(";
		for (int i = 0; i < opts.length; i++) {
			res += opts[i].contains(" ") ? '(' + opts[i] + ')' : opts[i];
			if (i < opts.length - 1) res += " | ";
		}
		return res + ")";
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		rules.forEach((k, v) -> sb.append(k + ':' + v));
		return sb.toString();
	}

	public Grammar removeRule(String name) {
		if (name != null) {
			if (name.startsWith("$")) name = name.substring(1);
			this.rules.remove(name);
		}
		return this;
	}
	
	public Grammar addTransform(String name, Function<String,String> f) { RiScript.addTransform(name, f); return this; }
	public Grammar removeTransform(String name) { RiScript.removeTransform(name); return this; }
	public Grammar getTransforms() { return RiScript.getTransforms(); }

	public static void main(String[] args) {
		System.out.println(new Grammar(Util.opts("start", "(a | b | c)")));
		System.out.println(new Grammar("{\"start\": \"(a | b | c)\"}"));
	}

}
