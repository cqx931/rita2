package rita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import rita.RiTa;

public class TaggerTests {

	@Test
	public void testPosArray() {
		assertArrayEquals(RiTa.pos(new String[0]), new String[0]);
		assertArrayEquals(RiTa.pos(new String[] { "deal" }), new String[] { "nn" });
		assertArrayEquals(RiTa.pos(new String[] { "freed" }), new String[] { "jj" });
		assertArrayEquals(RiTa.pos(new String[] { "the" }), new String[] { "dt" });
		assertArrayEquals(RiTa.pos(new String[] { "a" }), new String[] { "dt" });
		assertArrayEquals(RiTa.pos("the top seed".split(" ")), new String[] { "dt", "jj", "nn" });
		assertArrayEquals(RiTa.pos("by illegal means".split(" ")), new String[] { "in", "jj", "nn" });
		assertArrayEquals(RiTa.pos("He outnumbers us".split(" ")), new String[] { "prp", "vbz", "prp" });
		assertArrayEquals(RiTa.pos("I outnumber you".split(" ")), new String[] { "prp", "vbp", "prp" });
		assertArrayEquals(RiTa.pos("Elephants dance".split(" ")), new String[] { "nns", "vbp" });
		assertArrayEquals(RiTa.pos("the boy dances".split(" ")), new String[] { "dt", "nn", "vbz" });
		assertArrayEquals(RiTa.pos("Dave dances".split(" ")), new String[] { "nnp", "vbz" });
	}

	@Test
	public void testPosArraySimple() {
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("simple", true);
		assertArrayEquals(RiTa.pos(new String[0], hm), new String[0]);
		assertArrayEquals(RiTa.pos(new String[] { "freed" }, hm), new String[] { "a" });
		assertArrayEquals(RiTa.pos(new String[] { "the" }, hm), new String[] { "-" });
		assertArrayEquals(RiTa.pos(new String[] { "a" }, hm), new String[] { "-" });
		assertArrayEquals(RiTa.pos("the top seed".split(" "), hm), new String[] { "-", "a", "n" });
		assertArrayEquals(RiTa.pos("by illegal means".split(" "), hm), new String[] { "-", "a", "n" });
		assertArrayEquals(RiTa.pos("He outnumbers us".split(" "), hm), new String[] { "-", "v", "-" });
		assertArrayEquals(RiTa.pos("I outnumber you".split(" "), hm), new String[] { "-", "v", "-" });
		assertArrayEquals(RiTa.pos("Elephants dance".split(" "), hm), new String[] { "n", "v" });
		assertArrayEquals(RiTa.pos("the boy dances".split(" "), hm), new String[] { "-", "n", "v" });
	}

	// NA: public void testPosArrayInlineSimple()

	@Test
	public void testInflectedVerbs() {
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("simple", true);

		assertArrayEquals(RiTa.pos("disbelieves"), new String[] { "vbz" });
		assertArrayEquals(RiTa.pos("disbelieves", hm), new String[] { "v" });

		assertArrayEquals(RiTa.pos("fates"), new String[] { "nns" });
		assertArrayEquals(RiTa.pos("fates", hm), new String[] { "n" });

		assertArrayEquals(RiTa.pos("hates"), new String[] { "vbz" });
		assertArrayEquals(RiTa.pos("hates", hm), new String[] { "v" });

		assertArrayEquals(RiTa.pos("hated"), new String[] { "vbd" });
		assertArrayEquals(RiTa.pos("hated", hm), new String[] { "v" });

		assertArrayEquals(RiTa.pos("hating"), new String[] { "vbg" });
		assertArrayEquals(RiTa.pos("hating", hm), new String[] { "v" });

		assertArrayEquals(RiTa.pos("He rode the horse"), new String[] { "prp", "vbd", "dt", "nn" });
		assertArrayEquals(RiTa.pos("He has ridden the horse"), new String[] { "prp", "vbz", "vbn", "dt", "nn" });

		assertArrayEquals(RiTa.pos("He rowed the boat"), new String[] { "prp", "vbd", "dt", "nn" });
		assertArrayEquals(RiTa.pos("He has rowed the boat"), new String[] { "prp", "vbz", "vbn", "dt", "nn" });

	}

	@Test
	public void testPos() {

		String[] result, answer, resultArr, answerArr;
		String txt;

		assertArrayEquals(RiTa.pos(""), new String[] {});
		assertArrayEquals(RiTa.pos("freed"), new String[] { "jj" });
		assertArrayEquals(RiTa.pos("biped"), new String[] { "nn" });
		assertArrayEquals(RiTa.pos("greed"), new String[] { "nn" });
		assertArrayEquals(RiTa.pos("creed"), new String[] { "nn" });
		assertArrayEquals(RiTa.pos("weed"), new String[] { "nn" });

		assertArrayEquals(RiTa.pos("the top seed"), new String[] { "dt", "jj", "nn" });
		assertArrayEquals(RiTa.pos("by illegal means"), new String[] { "in", "jj", "nn" });
		assertArrayEquals(RiTa.pos("Joanny Smith ran away"), new String[] { "nnp", "nnp", "vbd", "rb" });

		result = RiTa.pos("mammal");
		answer = new String[] { "nn" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("asfaasd");
		answer = new String[] { "nn" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("innings");
		answer = new String[] { "nns" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("clothes");
		answer = new String[] { "nns" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("teeth");
		answer = new String[] { "nns" };
		assertArrayEquals(result, answer);
		// return;

		result = RiTa.pos("memories");
		answer = new String[] { "nns" };
		assertArrayEquals(result, answer);

		assertArrayEquals(RiTa.pos("flunks"), new String[] { "vbz" });
		assertArrayEquals(RiTa.pos("outnumbers"), new String[] { "vbz" });
		assertArrayEquals(RiTa.pos("He outnumbers us"), new String[] { "prp", "vbz", "prp" });
		assertArrayEquals(RiTa.pos("I outnumber you"), new String[] { "prp", "vbp", "prp" });

		resultArr = RiTa.pos("Elephants dance");
		answerArr = new String[] { "nns", "vbp" };
		assertArrayEquals(answerArr, resultArr);

		result = RiTa.pos("the boy dances");
		answer = new String[] { "dt", "nn", "vbz" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("he dances");
		answer = new String[] { "prp", "vbz" };
		assertArrayEquals(result, answer);

		resultArr = RiTa.pos("Dave dances");
		answerArr = new String[] { "nnp", "vbz" };
		assertArrayEquals(answerArr, resultArr);

		result = RiTa.pos("running");
		answer = new String[] { "vbg" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("asserting");
		answer = new String[] { "vbg" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("assenting");
		answer = new String[] { "vbg" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("Dave");
		answer = new String[] { "nnp" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("They feed the cat");
		answer = new String[] { "prp", "vbp", "dt", "nn" };
		assertArrayEquals(result, answer);

		result = RiTa.pos("There is a cat.");
		answer = new String[] { "ex", "vbz", "dt", "nn", "." };
		assertArrayEquals(result, answer);

		result = RiTa.pos("The boy, dressed in red, ate an apple.");
		answer = new String[] { "dt", "nn", ",", "vbn", "in", "jj", ",", "vbd", "dt", "nn", "." };
		assertArrayEquals(result, answer);

		txt = "The dog ran faster than the other dog.  But the other dog was prettier.";
		result = RiTa.pos(txt);
		answer = new String[] { "dt", "nn", "vbd", "rbr", "in", "dt", "jj", "nn", ".", "cc", "dt", "jj", "nn", "vbd",
				"jjr", "." };
		assertArrayEquals(result, answer);

		// Tests for verb conjugation
		assertArrayEquals(RiTa.pos("is"), new String[] { "vbz" });
		assertArrayEquals(RiTa.pos("am"), new String[] { "vbp" });
		assertArrayEquals(RiTa.pos("be"), new String[] { "vb" });

		result = RiTa.pos("There is a cat.");
		answer = new String[] { "ex", "vbz", "dt", "nn", "." };
		assertArrayEquals(result, answer);

		result = RiTa.pos("There was a cat.");
		answer = new String[] { "ex", "vbd", "dt", "nn", "." };
		assertArrayEquals(result, answer);

		result = RiTa.pos("I am a cat.");
		answer = new String[] { "prp", "vbp", "dt", "nn", "." };
		assertArrayEquals(result, answer);

		result = RiTa.pos("I was a cat.");
		answer = new String[] { "prp", "vbd", "dt", "nn", "." };
		assertArrayEquals(result, answer);

		assertArrayEquals(RiTa.pos("flunk"), new String[] { "vb" });
		assertArrayEquals(RiTa.pos("He flunks the test"), new String[] { "prp", "vbz", "dt", "nn" });

		assertArrayEquals(RiTa.pos("he"), new String[] { "prp" });
		assertArrayEquals(RiTa.pos("outnumber"), new String[] { "vb" });
		assertArrayEquals(RiTa.pos("I outnumbered you"), new String[] { "prp", "vbd", "prp" });
		assertArrayEquals(RiTa.pos("She outnumbered us"), new String[] { "prp", "vbd", "prp" });
		assertArrayEquals(RiTa.pos("I am outnumbering you"), new String[] { "prp", "vbp", "vbg", "prp" });
		assertArrayEquals(RiTa.pos("I have outnumbered you"), new String[] { "prp", "vbp", "vbd", "prp" });

		String[] checks = new String[] { "emphasis", "stress", "discus", "colossus", "fibrosis", "digitalis",
				"pettiness", "mess", "cleanliness", "orderliness", "bronchitis", "preparedness", "highness" };
		for (int i = 0, j = checks.length; i < j; i++) {
			// if (RiTa.pos(checks[i])[0] !== "nn")
			// console.log(checks[i] + ": " + RiTa.pos(checks[i])[0]);
			assertArrayEquals(RiTa.pos(checks[i]), new String[] { "nn" });
		}
	}

	@Test
	public void testSimplePos() {
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("simple", true);

		assertArrayEquals(RiTa.pos("", hm), new String[] {});
		assertArrayEquals(RiTa.pos("biped", hm), new String[] { "n" });
		assertArrayEquals(RiTa.pos("creed", hm), new String[] { "n" });
		assertArrayEquals(RiTa.pos("weed", hm), new String[] { "n" });
		assertArrayEquals(RiTa.pos("is", hm), new String[] { "v" });
		assertArrayEquals(RiTa.pos("am", hm), new String[] { "v" });
		assertArrayEquals(RiTa.pos("be", hm), new String[] { "v" });
		assertArrayEquals(RiTa.pos("freed", hm), new String[] { "a" });
	}

	@Test
	public void testInlinePos() {

		String result, answer;
		String txt;

		// with Map (NOT relevant for Java as we can't have different return types)

		/*
		 * Map<String, Object> hm = new HashMap<String, Object>(); hm.put("inline",
		 * true);
		 * 
		 * assertEquals(RiTa.pos("", hm), ""); assertEquals(RiTa.pos("asdfaasd", hm),
		 * "asdfaasd/nn");
		 * 
		 * result = RiTa.pos("clothes", hm); answer = "clothes/nns";
		 * assertEquals(result, answer);
		 * 
		 * result = RiTa.pos("teeth", hm); answer = "teeth/nns"; assertEquals(result,
		 * answer);
		 * 
		 * result = RiTa.pos("There is a cat.", hm); answer =
		 * "There/ex is/vbz a/dt cat/nn ."; assertEquals(result, answer);
		 * 
		 * result = RiTa.pos("The boy, dressed in red, ate an apple.", hm); answer =
		 * "The/dt boy/nn , dressed/vbn in/in red/jj , ate/vbd an/dt apple/nn .";
		 * assertEquals(result, answer);
		 * 
		 * txt =
		 * "The dog ran faster than the other dog.  But the other dog was prettier.";
		 * result = RiTa.pos(txt, hm); answer =
		 * "The/dt dog/nn ran/vbd faster/rbr than/in the/dt other/jj dog/nn . But/cc the/dt other/jj dog/nn was/vbd prettier/jjr ."
		 * ; assertEquals(result, answer);
		 */

		// without Map argument
		assertEquals(RiTa.posInline(""), "");
		assertEquals(RiTa.posInline("asdfaasd"), "asdfaasd/nn");

		result = RiTa.posInline("clothes");
		answer = "clothes/nns";
		assertEquals(result, answer);

		result = RiTa.posInline("teeth");
		answer = "teeth/nns";
		assertEquals(result, answer);

		result = RiTa.posInline("There is a cat.");
		answer = "There/ex is/vbz a/dt cat/nn .";
		assertEquals(result, answer);

		result = RiTa.posInline("The boy, dressed in red, ate an apple.");
		answer = "The/dt boy/nn , dressed/vbn in/in red/jj , ate/vbd an/dt apple/nn .";
		assertEquals(result, answer);

		txt = "The dog ran faster than the other dog.  But the other dog was prettier.";
		result = RiTa.posInline(txt);
		answer = "The/dt dog/nn ran/vbd faster/rbr than/in the/dt other/jj dog/nn . But/cc the/dt other/jj dog/nn was/vbd prettier/jjr .";
		assertEquals(result, answer);
	}

	@Test
	public void testInlinePosSimple() {
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("simple", true);

		String result, answer;
		String txt;

		// posInline
		assertEquals(RiTa.posInline("asdfaasd", hm), "asdfaasd/n");

		result = RiTa.posInline("clothes", hm);
		answer = "clothes/n";
		assertEquals(result, answer);

		result = RiTa.posInline("teeth", hm);
		answer = "teeth/n";
		assertEquals(result, answer);

		result = RiTa.posInline("There is a cat.", hm);
		answer = "There/- is/v a/- cat/n .";
		assertEquals(result, answer);

		result = RiTa.posInline("The boy, dressed in red, ate an apple.", hm);
		answer = "The/- boy/n , dressed/v in/- red/a , ate/v an/- apple/n .";
		assertEquals(result, answer);

		txt = "The dog ran faster than the other dog.  But the other dog was prettier.";
		result = RiTa.posInline(txt, hm);
		answer = "The/- dog/n ran/v faster/r than/- the/- other/a dog/n . But/- the/- other/a dog/n was/v prettier/a .";
		assertEquals(result, answer);

		// with Map (NOT relevant for Java as we can't have different return types)

		/*
		 * pos, add inline hm.put("inline", true);
		 * 
		 * assertEquals(RiTa.pos("", hm), ""); assertEquals(RiTa.pos("asdfaasd", hm),
		 * "asdfaasd/n");
		 * 
		 * result = RiTa.pos("clothes", hm); answer = "clothes/n"; assertEquals(result,
		 * answer);
		 * 
		 * result = RiTa.pos("teeth", hm); answer = "teeth/n"; assertEquals(result,
		 * answer);
		 * 
		 * result = RiTa.pos("There is a cat.", hm); answer =
		 * "There/- is/v a/- cat/n ."; assertEquals(result, answer);
		 * 
		 * result = RiTa.pos("The boy, dressed in red, ate an apple.", hm); answer =
		 * "The/- boy/n , dressed/v in/- red/a , ate/v an/- apple/n .";
		 * assertEquals(result, answer);
		 * 
		 * txt =
		 * "The dog ran faster than the other dog.  But the other dog was prettier.";
		 * result = RiTa.pos(txt, hm); answer =
		 * "The/- dog/n ran/v faster/r than/- the/- other/a dog/n . But/- the/- other/a dog/n was/v prettier/a ."
		 * ; assertEquals(result, answer);
		 */
	}

	@Test
	public void testIsAdverb() {

		assertTrue(!RiTa.isAdverb(""));
		assertTrue(!RiTa.isAdverb("swim"));
		assertTrue(!RiTa.isAdverb("walk"));
		assertTrue(!RiTa.isAdverb("walker"));
		assertTrue(!RiTa.isAdverb("beautiful"));
		assertTrue(!RiTa.isAdverb("dance"));
		assertTrue(!RiTa.isAdverb("dancing"));
		assertTrue(!RiTa.isAdverb("dancer"));

		// verb
		assertTrue(!RiTa.isAdverb("wash"));
		assertTrue(!RiTa.isAdverb("walk"));
		assertTrue(!RiTa.isAdverb("play"));
		assertTrue(!RiTa.isAdverb("throw"));
		assertTrue(!RiTa.isAdverb("drink"));
		assertTrue(!RiTa.isAdverb("eat"));
		assertTrue(!RiTa.isAdverb("chew"));

		// adj
		assertTrue(!RiTa.isAdverb("wet"));
		assertTrue(!RiTa.isAdverb("dry"));
		assertTrue(!RiTa.isAdverb("furry"));
		assertTrue(!RiTa.isAdverb("sad"));
		assertTrue(!RiTa.isAdverb("happy"));

		// n
		assertTrue(!RiTa.isAdverb("dogs"));
		assertTrue(!RiTa.isAdverb("wind"));
		assertTrue(!RiTa.isAdverb("dolls"));
		assertTrue(!RiTa.isAdverb("frogs"));
		assertTrue(!RiTa.isAdverb("ducks"));
		assertTrue(!RiTa.isAdverb("flowers"));
		assertTrue(!RiTa.isAdverb("fish"));

		// adv
		assertTrue(RiTa.isAdverb("truthfully"));
		assertTrue(RiTa.isAdverb("kindly"));
		assertTrue(RiTa.isAdverb("bravely"));
		assertTrue(RiTa.isAdverb("doggedly"));
		assertTrue(RiTa.isAdverb("sleepily"));
		assertTrue(RiTa.isAdverb("excitedly"));
		assertTrue(RiTa.isAdverb("energetically"));
		assertTrue(RiTa.isAdverb("hard")); // +adj
	}

	@Test
	public void testIsNoun() {

		// nn

		assertTrue(RiTa.isNoun("thieves"));
		assertTrue(RiTa.isNoun("calves"));
		assertTrue(RiTa.isNoun("boxes"));

		assertTrue(RiTa.isNoun("swim"));
		assertTrue(RiTa.isNoun("walk"));
		assertTrue(RiTa.isNoun("walker"));
		assertTrue(RiTa.isNoun("dance"));
		assertTrue(RiTa.isNoun("dancer"));
		assertTrue(RiTa.isNoun("cats"));
		assertTrue(RiTa.isNoun("teeth"));
		assertTrue(RiTa.isNoun("apples"));
		assertTrue(RiTa.isNoun("buses"));
		assertTrue(RiTa.isNoun("prognoses"));
		assertTrue(RiTa.isNoun("oxen"));
		assertTrue(RiTa.isNoun("theses"));
		assertTrue(RiTa.isNoun("stimuli"));
		assertTrue(RiTa.isNoun("crises"));
		assertTrue(RiTa.isNoun("duck"));
		assertTrue(RiTa.isNoun("dog"));

		// verb
		assertTrue(RiTa.isNoun("wash")); // "TODO:also false in processing -> nn" shoulbe be both Verb and Noun ??
		assertTrue(RiTa.isNoun("walk"));
		assertTrue(RiTa.isNoun("play"));
		assertTrue(RiTa.isNoun("throw"));
		assertTrue(RiTa.isNoun("drink")); // TODO:"also false in processing -> nn" shoulbe be both Verb and Noun ??

		assertTrue(!RiTa.isNoun("eat"));
		assertTrue(!RiTa.isNoun("chew"));
		assertTrue(!RiTa.isNoun("moved"));
		assertTrue(!RiTa.isNoun("went"));
		assertTrue(!RiTa.isNoun("spent"));
		assertTrue(!RiTa.isNoun("abates"));

		// adj
		assertTrue(!RiTa.isNoun("hard"));
		assertTrue(!RiTa.isNoun("dry"));
		assertTrue(!RiTa.isNoun("furry"));
		assertTrue(!RiTa.isNoun("sad"));
		assertTrue(!RiTa.isNoun("happy"));
		assertTrue(!RiTa.isNoun("beautiful"));
		assertTrue(RiTa.isNoun("wet")); // +v/adj

		// n
		assertTrue(RiTa.isNoun("dogs"));
		assertTrue(RiTa.isNoun("wind"));
		assertTrue(RiTa.isNoun("dolls"));
		assertTrue(RiTa.isNoun("frogs"));
		assertTrue(RiTa.isNoun("ducks"));
		assertTrue(RiTa.isNoun("flower"));
		assertTrue(RiTa.isNoun("fish"));

		// adv
		assertTrue(!RiTa.isNoun("truthfully"));
		assertTrue(!RiTa.isNoun("kindly"));
		assertTrue(!RiTa.isNoun("bravely"));
		assertTrue(!RiTa.isNoun("scarily"));
		assertTrue(!RiTa.isNoun("sleepily"));
		assertTrue(!RiTa.isNoun("excitedly"));
		assertTrue(!RiTa.isNoun("energetically"));
	}

	@Test
	public void testIsVerb() {
		assertTrue(RiTa.isVerb("abandons"));

		assertTrue(RiTa.isVerb("dance"));
		assertTrue(RiTa.isVerb("swim"));
		assertTrue(RiTa.isVerb("walk"));

		assertTrue(RiTa.isVerb("dances"));
		assertTrue(RiTa.isVerb("swims"));
		assertTrue(RiTa.isVerb("walks"));
		assertTrue(RiTa.isVerb("costs"));

		// inflections
		assertTrue(RiTa.isVerb("danced"));
		assertTrue(RiTa.isVerb("swam"));
		assertTrue(RiTa.isVerb("walked"));
		assertTrue(RiTa.isVerb("costed"));
		assertTrue(RiTa.isVerb("satisfies"));
		assertTrue(RiTa.isVerb("falsifies"));
		assertTrue(RiTa.isVerb("beautifies"));
		assertTrue(RiTa.isVerb("repossesses"));

		assertTrue(!RiTa.isVerb("dancer"));
		assertTrue(!RiTa.isVerb("walker"));
		assertTrue(!RiTa.isVerb("beautiful"));

		// verb
		assertTrue(RiTa.isVerb("eat"));
		assertTrue(RiTa.isVerb("chew"));

		assertTrue(RiTa.isVerb("throw")); // +n
		assertTrue(RiTa.isVerb("walk")); // +n
		assertTrue(RiTa.isVerb("wash")); // +n
		assertTrue(RiTa.isVerb("drink")); // +n

		// assertTrue(RiTa.isVerb("ducks")); // +n -> Known Issues
		assertTrue(RiTa.isVerb("fish")); // +n
		// assertTrue(RiTa.isVerb("dogs")); // +n -> Known Issues

		assertTrue(RiTa.isVerb("wind")); // +n
		assertTrue(RiTa.isVerb("wet")); // +adj
		assertTrue(RiTa.isVerb("dry")); // +adj

		// adj
		assertTrue(!RiTa.isVerb("hard"));
		assertTrue(!RiTa.isVerb("furry"));
		assertTrue(!RiTa.isVerb("sad"));
		assertTrue(!RiTa.isVerb("happy"));

		// n
		assertTrue(!RiTa.isVerb("dolls"));
		assertTrue(!RiTa.isVerb("frogs"));

		// ok
		assertTrue(RiTa.isVerb("flowers"));
		assertTrue(RiTa.isVerb("ducks"));

		// adv
		assertTrue(!RiTa.isVerb("truthfully"));
		assertTrue(!RiTa.isVerb("kindly"));
		assertTrue(!RiTa.isVerb("bravely"));
		assertTrue(!RiTa.isVerb("scarily"));
		assertTrue(!RiTa.isVerb("sleepily"));
		assertTrue(!RiTa.isVerb("excitedly"));
		assertTrue(!RiTa.isVerb("energetically"));

		assertTrue(RiTa.isVerb("hates"));
		assertTrue(RiTa.isVerb("hated"));
		assertTrue(RiTa.isVerb("hating"));
		assertTrue(RiTa.isVerb("dancing"));

		assertTrue(RiTa.isVerb("hates"));
		assertTrue(RiTa.isVerb("hated"));
		assertTrue(RiTa.isVerb("ridden"));

	}

	@Test
	public void testIsAdjective() {

		assertTrue(!RiTa.isAdjective("swim"));
		assertTrue(!RiTa.isAdjective("walk"));
		assertTrue(!RiTa.isAdjective("walker"));
		assertTrue(RiTa.isAdjective("beautiful"));
		assertTrue(!RiTa.isAdjective("dance"));
		assertTrue(!RiTa.isAdjective("dancing"));
		assertTrue(!RiTa.isAdjective("dancer"));

		// verb
		assertTrue(!RiTa.isAdjective("wash"));
		assertTrue(!RiTa.isAdjective("walk"));
		assertTrue(!RiTa.isAdjective("play"));
		assertTrue(!RiTa.isAdjective("throw"));
		assertTrue(!RiTa.isAdjective("drink"));
		assertTrue(!RiTa.isAdjective("eat"));
		assertTrue(!RiTa.isAdjective("chew"));

		// adj
		assertTrue(RiTa.isAdjective("hard"));
		assertTrue(RiTa.isAdjective("wet"));
		assertTrue(RiTa.isAdjective("dry"));
		assertTrue(RiTa.isAdjective("furry"));
		assertTrue(RiTa.isAdjective("sad"));
		assertTrue(RiTa.isAdjective("happy"));
		assertTrue(RiTa.isAdjective("kindly")); // +adv

		// n
		assertTrue(!RiTa.isAdjective("dog"));
		assertTrue(!RiTa.isAdjective("dogs"));
		assertTrue(!RiTa.isAdjective("wind"));
		assertTrue(!RiTa.isAdjective("dolls"));
		assertTrue(!RiTa.isAdjective("frogs"));
		assertTrue(!RiTa.isAdjective("ducks"));
		assertTrue(!RiTa.isAdjective("flowers"));
		assertTrue(!RiTa.isAdjective("fish"));

		// adv
		assertTrue(!RiTa.isAdjective("truthfully"));
		assertTrue(!RiTa.isAdjective("bravely"));
		assertTrue(!RiTa.isAdjective("scarily"));
		assertTrue(!RiTa.isAdjective("sleepily"));
		assertTrue(!RiTa.isAdjective("excitedly"));
		assertTrue(!RiTa.isAdjective("energetically"));
	}

}
