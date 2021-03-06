/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rita.test;

import static org.junit.jupiter.api.Assertions.*;

import rita.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class AnalyzerTests { // NOT IN SYNC WITH JS

	@Test
	public void testSingularize() {

		String[] tests = {
				"media", "medium",
				"millennia", "millennium",
				"consortia", "consortium",
				"concerti", "concerto",
				"septa", "septum",
				"termini", "terminus",
				"larvae", "larva",
				"vertebrae", "vertebra",
				"memorabilia", "memorabilium",
				"hooves", "hoof",
				"thieves", "thief",
				"rabbis", "rabbi",
				"flu", "flu",
				"safaris", "safari",
				"sheaves", "sheaf",
				"uses", "use",
				"pinches", "pinch",
				"catharses", "catharsis",
				"hankies", "hanky"
		};
		for (int i = 0; i < tests.length; i += 2) {
			// System.out.println("p: " + RiTa.singularize(tests[i])
			// + " s: " + tests[i + 1]);
			eq(RiTa.singularize(tests[i]), tests[i + 1]);
		}

		eq(RiTa.singularize("pleae"), "pleae"); // special-cased in code?
		eq(RiTa.singularize("whizzes"), "whiz");
		eq(RiTa.singularize("selves"), "self");
		eq(RiTa.singularize("bookshelves"), "bookshelf");
		eq(RiTa.singularize("wheezes"), "wheeze");
		eq(RiTa.singularize("diagnoses"), "diagnosis");

		eq("minutia", RiTa.singularize("minutia"));
		eq("blonde", RiTa.singularize("blondes"));
		eq("eye", RiTa.singularize("eyes"));
		eq(RiTa.singularize("swine"), "swine");
		eq(RiTa.singularize("cognoscenti"), "cognoscenti");
		eq(RiTa.singularize("bonsai"), "bonsai");
		eq(RiTa.singularize("taxis"), "taxi");
		eq(RiTa.singularize("chiefs"), "chief");
		eq(RiTa.singularize("monarchs"), "monarch");
		eq(RiTa.singularize("lochs"), "loch");
		eq(RiTa.singularize("stomachs"), "stomach");

		eq(RiTa.singularize("Chinese"), "Chinese");

		eq(RiTa.singularize("people"), "person");
		eq(RiTa.singularize("money"), "money");
		eq(RiTa.singularize("vertebrae"), "vertebra");
		eq(RiTa.singularize("humans"), "human");
		eq(RiTa.singularize("germans"), "german");
		eq(RiTa.singularize("romans"), "roman");

		eq(RiTa.singularize("memoranda"), "memorandum");
		eq(RiTa.singularize("data"), "datum");
		eq(RiTa.singularize("appendices"), "appendix");
		eq(RiTa.singularize("theses"), "thesis");
		eq(RiTa.singularize("alumni"), "alumnus");

		eq(RiTa.singularize("solos"), "solo");
		eq(RiTa.singularize("music"), "music");

		eq(RiTa.singularize("oxen"), "ox");
		eq(RiTa.singularize("solos"), "solo");
		eq(RiTa.singularize("music"), "music");
		eq(RiTa.singularize("money"), "money");
		eq(RiTa.singularize("beef"), "beef");

		eq(RiTa.singularize("tobacco"), "tobacco");
		eq(RiTa.singularize("cargo"), "cargo");
		eq(RiTa.singularize("golf"), "golf");
		eq(RiTa.singularize("grief"), "grief");

		eq(RiTa.singularize("cakes"), "cake");

		eq("dog", RiTa.singularize("dogs"));
		eq("foot", RiTa.singularize("feet"));
		eq("tooth", RiTa.singularize("teeth"));
		eq("kiss", RiTa.singularize("kisses"));
		eq("child", RiTa.singularize("children"));
		eq("randomword", RiTa.singularize("randomwords"));
		eq("deer", RiTa.singularize("deer"));
		eq("sheep", RiTa.singularize("sheep"));
		eq("shrimp", RiTa.singularize("shrimp"));

		eq(RiTa.singularize("tomatoes"), "tomato");
		eq(RiTa.singularize("photos"), "photo");

		eq(RiTa.singularize("toes"), "toe");

		eq(RiTa.singularize("series"), "series");
		eq(RiTa.singularize("oxen"), "ox");
		eq(RiTa.singularize("men"), "man");
		eq(RiTa.singularize("mice"), "mouse");
		eq(RiTa.singularize("lice"), "louse");
		eq(RiTa.singularize("children"), "child");

		eq(RiTa.singularize("gases"), "gas");
		eq(RiTa.singularize("buses"), "bus");
		eq(RiTa.singularize("happiness"), "happiness");

		eq(RiTa.singularize("crises"), "crisis");
		eq(RiTa.singularize("theses"), "thesis");
		eq(RiTa.singularize("apotheses"), "apothesis");
		eq(RiTa.singularize("stimuli"), "stimulus");
		eq(RiTa.singularize("alumni"), "alumnus");
		eq(RiTa.singularize("corpora"), "corpus");

		eq("man", RiTa.singularize("men"));
		eq("woman", RiTa.singularize("women"));
		eq("congressman", RiTa.singularize("congressmen"));
		eq("alderman", RiTa.singularize("aldermen"));
		eq("freshman", RiTa.singularize("freshmen"));
		eq("fireman", RiTa.singularize("firemen"));
		eq("grandchild", RiTa.singularize("grandchildren"));
		eq("menu", RiTa.singularize("menus"));
		eq("guru", RiTa.singularize("gurus"));

		eq("", RiTa.singularize(""));
		eq("hardness", RiTa.singularize("hardness"));
		eq("shortness", RiTa.singularize("shortness"));
		eq("dreariness", RiTa.singularize("dreariness"));
		eq("unwillingness", RiTa.singularize("unwillingness"));
		eq("deer", RiTa.singularize("deer"));
		eq("fish", RiTa.singularize("fish"));
		eq("ooze", RiTa.singularize("ooze"));

		eq("ooze", RiTa.singularize("ooze"));
		eq("enterprise", RiTa.singularize("enterprises"));
		eq("treatise", RiTa.singularize("treatises"));
		eq("house", RiTa.singularize("houses"));
		eq("chemise", RiTa.singularize("chemises"));

		eq("aquatics", RiTa.singularize("aquatics"));
		eq("mechanics", RiTa.singularize("mechanics"));
		eq("quarter", RiTa.singularize("quarters"));

	}

	@Test
	public void testPluralize() {
		String[] tests = {
				"media", "medium",
				"millennia", "millennium",
				"consortia", "consortium",
				"concerti", "concerto",
				"septa", "septum",
				"termini", "terminus",
				"larvae", "larva",
				"vertebrae", "vertebra",
				"memorabilia", "memorabilium",
				"sheaves", "sheaf",
				"spoofs", "spoof",
				"proofs", "proof",
				"roofs", "roof",
				"disbeliefs", "disbelief",
				"indices", "index",
				"accomplices", "accomplice"
		};
		for (int i = 0; i < tests.length; i += 2) {
			// System.out.println("singular: " + tests[i]);
			// System.out.println("plural: " + RiTa.pluralize(tests[i + 1]));
			eq(tests[i], RiTa.pluralize(tests[i + 1]));
		}

		// uncountable
		tests = new String[] {
				"turf", "macaroni", "spaghetti", "potpourri", "electrolysis"
		};
		for (int i = 0; i < tests.length; i++) {
			eq(tests[i], RiTa.pluralize(tests[i]));
		}

		eq("blondes", RiTa.pluralize("blonde"));
		eq("eyes", RiTa.pluralize("eye"));
		eq("blondes", RiTa.pluralize("blond"));

		eq("dogs", RiTa.pluralize("dog"));
		eq("feet", RiTa.pluralize("foot"));
		eq("men", RiTa.pluralize("man"));

		eq("beautifuls", RiTa.pluralize("beautiful"));
		eq("teeth", RiTa.pluralize("tooth"));
		eq("cakes", RiTa.pluralize("cake"));
		eq("kisses", RiTa.pluralize("kiss"));
		eq("children", RiTa.pluralize("child"));

		eq("randomwords", RiTa.pluralize("randomword"));
		eq("lice", RiTa.pluralize("louse"));

		eq("sheep", RiTa.pluralize("sheep"));
		eq("shrimp", RiTa.pluralize("shrimp"));
		eq("series", RiTa.pluralize("series"));
		eq("mice", RiTa.pluralize("mouse"));

		eq("", RiTa.pluralize(""));

		eq(RiTa.pluralize("tomato"), "tomatoes");
		eq(RiTa.pluralize("toe"), "toes");

		eq(RiTa.pluralize("deer"), "deer");
		eq(RiTa.pluralize("ox"), "oxen");

		eq(RiTa.pluralize("tobacco"), "tobacco");
		eq(RiTa.pluralize("cargo"), "cargo");
		eq(RiTa.pluralize("golf"), "golf");
		eq(RiTa.pluralize("grief"), "grief");
		eq(RiTa.pluralize("wildlife"), "wildlife");
		eq(RiTa.pluralize("taxi"), "taxis");
		eq(RiTa.pluralize("Chinese"), "Chinese");
		eq(RiTa.pluralize("bonsai"), "bonsai");

		eq(RiTa.pluralize("whiz"), "whizzes");
		eq(RiTa.pluralize("prognosis"), "prognoses");
		eq(RiTa.pluralize("gas"), "gases");
		eq(RiTa.pluralize("bus"), "buses");

		eq("crises", RiTa.pluralize("crisis"));
		eq("theses", RiTa.pluralize("thesis"));
		eq("apotheses", RiTa.pluralize("apothesis"));
		eq("stimuli", RiTa.pluralize("stimulus"));
		eq("alumni", RiTa.pluralize("alumnus"));
		eq("corpora", RiTa.pluralize("corpus"));
		eq("menus", RiTa.pluralize("menu"));

		eq("hardness", RiTa.pluralize("hardness"));
		eq("shortness", RiTa.pluralize("shortness"));
		eq("dreariness", RiTa.pluralize("dreariness"));
		eq("unwillingness", RiTa.pluralize("unwillingness"));
		eq("deer", RiTa.pluralize("deer"));
		eq("fish", RiTa.pluralize("fish"));
		eq("moose", RiTa.pluralize("moose"));

		eq("aquatics", RiTa.pluralize("aquatics"));
		eq("mechanics", RiTa.pluralize("mechanics"));
	}
	
	
	@Test
	public void testSingularPluralPairs() {

    String[] testPairs = {
      "dazes", "daze",
      "hives", "hive",
      "dives", "dive",
      "octopuses", "octopus",
      "abalone", "abalone",
      "wildlife", "wildlife",
      "media", "medium",
      "millennia", "millennium",
      "consortia", "consortium",
      "concerti", "concerto",
      "septa", "septum",
      "termini", "terminus",
      "larvae", "larva",
      "minutiae", "minutia",
      "vertebrae", "vertebra",
      "hooves", "hoof",
      "thieves", "thief",
      "rabbis", "rabbi",
      "flu", "flu",
      "safaris", "safari",
      "sheaves", "sheaf",
      "uses", "use",
      "pinches", "pinch",
      "hankies", "hanky",
      "spoofs", "spoof",
      "proofs", "proof",
      "roofs", "roof",
      "disbeliefs", "disbelief",
      "beliefs", "belief",
      "indices", "index",
      "accomplices", "accomplice",
      "catharses", "catharsis",
      "prognoses", "prognosis",
      "whizzes", "whiz",
      "selves", "self",
      "bookshelves", "bookshelf",
      "wheezes", "wheeze",
      "diagnoses", "diagnosis",
      "minutiae", "minutia",
      "blondes", "blonde",
      "eyes", "eye",
      "swine", "swine",
      "cognoscenti", "cognoscenti",
      "bonsai", "bonsai",
      "taxis", "taxi",
      "chiefs", "chief",
      "monarchs", "monarch",
      "lochs", "loch",
      "stomachs", "stomach",
      "Chinese", "Chinese",
      "people", "person",
      "humans", "human",
      "germans", "german",
      "romans", "roman",
      "memoranda", "memorandum",
      "data", "datum",
      "geese", "goose",
      "femurs", "femur",
      "appendices", "appendix",
      "theses", "thesis",
      "alumni", "alumnus",
      "solos", "solo",
      "music", "music",
      "oxen", "ox",
      "solos", "solo",
      "music", "music",
      "money", "money",
      "beef", "beef",
      "tobacco", "tobacco",
      "cargo", "cargo",
      "golf", "golf",
      "grief", "grief",
      "cakes", "cake",
      "tomatoes", "tomato",
      "photos", "photo",
      "smallpox", "smallpox",
      "toes", "toe",
      "series", "series",
      "oxen", "ox",
      "men", "man",
      "mice", "mouse",
      "lice", "louse",
      "children", "child",
      "gases", "gas",
      "buses", "bus",
      "happiness", "happiness",
      "crises", "crisis",
      "theses", "thesis",
      "apotheses", "apothesis",
      "stimuli", "stimulus",
      "alumni", "alumnus",
      "corpora", "corpus",
      "dogs", "dog",
      "feet", "foot",
      "teeth", "tooth",
      "kisses", "kiss",
      "deer", "deer",
      "sheep", "sheep",
      "shrimp", "shrimp",
      "men", "man",
      "women", "woman",
      "congressmen", "congressman",
      "aldermen", "alderman",
      "freshmen", "freshman",
      "firemen", "fireman",
      "grandchildren", "grandchild",
      "menus", "menu",
      "gurus", "guru",
      "hardness", "hardness",
      "shortness", "shortness",
      "dreariness", "dreariness",
      "unwillingness", "unwillingness",
      "fish", "fish",
      "ooze", "ooze",
      "enterprises", "enterprise",
      "treatises", "treatise",
      "houses", "house",
      "chemises", "chemise",
      "aquatics", "aquatics",
      "mechanics", "mechanics",
      "quarters", "quarter",
      "motifs", "motif",
      "alumni", "alumnus",
      "turf", "turf",
      "macaroni", "macaroni",
      "spaghetti", "spaghetti",
      "potpourri", "potpourri",
      "electrolysis", "electrolysis",
      "eyes", "eye",
      "teeth", "tooth",
      "cakes", "cake",
      "kisses", "kiss",
      "lice", "louse",
      "series", "series",
      "crises", "crisis",
      "theses", "thesis",
      "apotheses", "apothesis",
      "stimuli", "stimulus",
      "alumni", "alumnus",
      "corpora", "corpus",
      "menus", "menu",
      "hardness", "hardness",
      "shortness", "shortness",
      "dreariness", "dreariness",
      "unwillingness", "unwillingness",
      "moose", "moose",
      "toes", "toe",
      "tobacco", "tobacco",
      "cargo", "cargo",
      "golf", "golf",
      "grief", "grief",
      "taxis", "taxi",
      "bonsai", "bonsai",
      "lives", "life",
      "additives", "additive",
      "epochs", "epoch",
      "ranchs", "ranch",
      "alcoves", "alcove",
      "goddesses", "goddess",
      "tresses", "tress",
      "murderesses", "murderess",
      "memories", "memory",
      "corpora", "corpus",
      "stimuli", "stimulus",
      "theses", "thesis"
    };

    String res1, res2; 
    boolean res3, dbug = false;

    for (int i = 0; i < testPairs.length; i += 2) {

      if (dbug) console.log(testPairs[i] + "/" + testPairs[i + 1]);

      res1 = Inflector.singularize(testPairs[i], Util.opts("dbug", dbug));
      res2 = Inflector.pluralize(testPairs[i + 1], Util.opts("dbug", dbug));
      res3 = Inflector.isPlural(testPairs[i], dbug);

      // singularize
      eq(res1, testPairs[i + 1], "FAIL: singularize(" + testPairs[i]
        + ") was " + res1 + ", but expected " + testPairs[i + 1] + "\n        "
        + "pluralize(" + testPairs[i + 1] + ") was " + res2 + "\n\n");

      // pluralize
      eq(res2, testPairs[i], "FAIL: pluralize(" + testPairs[i + 1]
        + ") was " + res2 + ", but expected " + testPairs[i] + "\n        "
        + "singularize(" + testPairs[i] + ") was " + res1 + "\n\n");

      // isPlural
      assertTrue(res3, "FAIL: isPlural(" + testPairs[i] + ") was false\n\n");
    }
  }

	@Test
	public void testAnalyzeLts() {
		// failing bc of testComputePhones (above)
		Map<String, String> feats = RiTa.analyze("cloze");
		eq(feats.get("pos"), "nn");
		eq(feats.get("tokens"), "cloze");
		eq(feats.get("syllables"), "k-l-ow-z");
	}

	@Test
	public void testAnalyze() {

		Map<String, String> feats;

		// analyze()
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("pos", "");
		hm.put("phones", "");
		hm.put("tokens", "");
		hm.put("stresses", "");
		hm.put("syllables", "");

		// System.out.println(RiTa.analyze(""));
		assertEquals(RiTa.analyze(""), hm);

		feats = RiTa.analyze("clothes");

		eq(feats.get("pos"), "nns");
		eq(feats.get("tokens"), "clothes");
		eq(feats.get("syllables"), "k-l-ow-dh-z");

		feats = RiTa.analyze("the clothes");

		eq(feats.get("pos"), "dt nns");
		eq(feats.get("tokens"), "the clothes");
		eq(feats.get("syllables"), "dh-ah k-l-ow-dh-z");

		feats = RiTa.analyze("chevrolet");
		eq(feats.get("tokens"), "chevrolet");
		eq(feats.get("syllables"), "sh-eh-v/r-ow/l-ey");
	}
	
	@Test
	public void testStresses() {

		String result, answer;

		result = RiTa.stresses("");
		answer = "";
		eq(result, answer);

		result = RiTa.stresses("The emperor had no clothes on");
		answer = "0 1/0/0 1 1 1 1";
		eq(result, answer);

		result = RiTa.stresses("The emperor had no clothes on.");
		answer = "0 1/0/0 1 1 1 1 .";
		eq(result, answer);

		result = RiTa.stresses("The emperor had no clothes on. The King is fat.");
		answer = "0 1/0/0 1 1 1 1 . 0 1 1 1 .";
		eq(result, answer);

		result = RiTa.stresses("to preSENT, to exPORT, to deCIDE, to beGIN");
		answer = "1 1/0 , 1 1/0 , 1 0/1 , 1 0/1";
		eq(result, answer);

		result = RiTa.stresses("to present, to export, to decide, to begin");
		answer = "1 1/0 , 1 1/0 , 1 0/1 , 1 0/1";
		eq(result, answer);

		result = RiTa.stresses("The dog ran faster than the other dog.  But the other dog was prettier.");
		answer = "0 1 1 1/0 1 0 1/0 1 . 1 0 1/0 1 1 1/0/0 .";
		eq(result, answer);

		eq(RiTa.stresses("chevrolet"), "0/0/1");
		eq(RiTa.stresses("women"), "1/0");
		eq(RiTa.stresses("abatements"), "0/1/0", "abatements");
		eq(RiTa.stresses("genuine"), "1/0/0");

	}

	@Test
	public void testPhonemes() {

		String result, answer;

		result = RiTa.phones("");
		answer = "";
		eq(result, answer);

		result = RiTa.phones("The");
		answer = "dh-ah";
		eq(result, answer);

		result = RiTa.phones("said");
		answer = "s-eh-d";
		eq(result, answer);

		result = RiTa.phones("The.");
		answer = "dh-ah .";
		eq(result, answer);

		result = RiTa.phones("The boy jumped over the wild dog.");
		answer = "dh-ah b-oy jh-ah-m-p-t ow-v-er dh-ah w-ay-l-d d-ao-g .";
		eq(result, answer);

		result = RiTa.phones("The boy ran to the store.");
		answer = "dh-ah b-oy r-ae-n t-uw dh-ah s-t-ao-r .";
		eq(result, answer);

		result = RiTa.phones("The dog ran faster than the other dog.  But the other dog was prettier.");
		answer = "dh-ah d-ao-g r-ae-n f-ae-s-t-er dh-ae-n dh-ah ah-dh-er d-ao-g . b-ah-t dh-ah ah-dh-er d-ao-g w-aa-z p-r-ih-t-iy-er .";
		eq(result, answer);

		result = RiTa.phones("flowers");
		answer = "f-l-aw-er-z";
		eq(result, answer);

		result = RiTa.phones("quiche");
		answer = "k-iy-sh";
		eq(result, answer);

		result = RiTa.phones("mice");
		answer = "m-ay-s";
		eq(result, answer);

		eq(RiTa.phones("chevrolet"), "sh-eh-v-r-ow-l-ey");
		eq(RiTa.phones("women"), "w-ih-m-eh-n");
		eq(RiTa.phones("genuine"), "jh-eh-n-y-uw-w-ah-n");

	}

	@Test
	public void testSyllables() {
		// syllables()

		eq(RiTa.syllables("clothes"), "k-l-ow-dh-z");

		eq(RiTa.syllables(""), "");
		eq(RiTa.syllables("chevrolet"), "sh-eh-v/r-ow/l-ey");

		eq(RiTa.syllables("women"), "w-ih/m-eh-n");
		eq(RiTa.syllables("genuine"), "jh-eh-n/y-uw/w-ah-n");

		String input, expected;

		input = "The emperor had no clothes on.";
		expected = "dh-ah eh-m/p-er/er hh-ae-d n-ow k-l-ow-dh-z aa-n .";
		eq(RiTa.syllables(input), expected);

		input = "The dog ran faster than the other dog. But the other dog was prettier.";
		expected = "dh-ah d-ao-g r-ae-n f-ae/s-t-er dh-ae-n dh-ah ah/dh-er d-ao-g . b-ah-t dh-ah ah/dh-er d-ao-g w-aa-z p-r-ih/t-iy/er .";
		eq(RiTa.syllables(input), expected);

		input = "The dog ran faster than the other dog. But the other dog was prettier.";
		expected = "dh-ah d-ao-g r-ae-n f-ae/s-t-er dh-ae-n dh-ah ah/dh-er d-ao-g . b-ah-t dh-ah ah/dh-er d-ao-g w-aa-z p-r-ih/t-iy/er .";
		eq(RiTa.syllables(input), expected);

		input = "The emperor had no clothes on.";
		expected = "dh-ah eh-m/p-er/er hh-ae-d n-ow k-l-ow-dh-z aa-n .";
		eq(RiTa.syllables(input), expected);

		RiTa.SILENCE_LTS = true; // TODO : why ??
		//System.out.println(RiTa.syllables("The Laggin Dragon"));
		eq(RiTa.syllables("The Laggin Dragon"), "dh-ah l-ae/g-ih-n d-r-ae/g-ah-n");
		RiTa.SILENCE_LTS = false;
	}

	static void eq(String a, String b) {
		eq(a, b, "");
	}

	static void eq(String a, String b, String msg) {
		assertEquals(b, a, msg);
	}
}
