package rita.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rita.RiTa;

public class RiTaApi {

	// TODO

	@Test
	public void testRiTaApi() {

		// Should access static constants

		assertEquals(RiTa.VERSION, "2");

		System.out.println(RiTa.hasWord("dog"));
		// Should access static functions
		assertEquals(RiTa.hasWord("dog"), true);
		/*
		 * //Should access member classes RiMarkov rm = new RiTa.RiMarkov(3);
		 * assertEquals(rm.n,3);
		 * 
		 * 
		 * //Should call alliterations expect(RiTa.alliterations).to.be.a('function');
		 * 
		 * //Should call analyze expect(RiTa.analyze).to.be.a('function');
		 * 
		 * //Should call concordance expect(RiTa.concordance).to.be.a('function');
		 * 
		 * //Should call conjugate expect(RiTa.conjugate).to.be.a('function');
		 * 
		 * //Should call hasWord assertEquals(RiTa.hasWord('dog'),true);
		 * assertEquals(RiTa.hasWord(''),false);
		 * 
		 * //Should call env assertEquals(RiTa.env(),'node');
		 * 
		 * //Should call pastParticiple expect(RiTa.pastParticiple).to.be.a('function');
		 * 
		 * //Should call phonemes expect(RiTa.phonemes).to.be.a('function');
		 * 
		 * //Should call posTags expect(RiTa.pos).to.be.a('function');
		 * 
		 * //Should call presentParticiple
		 * 
		 * expect(RiTa.presentParticiple).to.be.a('function');
		 * 
		 * //Should call stresses expect(RiTa.stresses).to.be.a('function');
		 * 
		 * //Should call stresses expect(RiTa.syllables).to.be.a('function');
		 * 
		 * //Should call isAbbreviation expect(RiTa.isAbbreviation).to.be.a('function');
		 * 
		 * //Should call isAdjective expect(RiTa.isAdjective).to.be.a('function');
		 * 
		 * //Should call isAdverb expect(RiTa.isAdverb).to.be.a('function');
		 * 
		 * //Should call isAlliteration expect(RiTa.isAlliteration).to.be.a('function');
		 * 
		 * //Should call isNoun expect(RiTa.isNoun).to.be.a('function');
		 * 
		 * //Should call isPunctuation expect(RiTa.isPunctuation).to.be.a('function');
		 * 
		 * //Should call isQuestion expect(RiTa.isQuestion).to.be.a('function');
		 * 
		 * //Should call isRhyme expect(RiTa.isRhyme).to.be.a('function');
		 * 
		 * //Should call isVerb expect(RiTa.isVerb).to.be.a('function');
		 * 
		 * //Should call kwic RiTa.concordance('The dog ate the cat');
		 * expect(RiTa.kwic('')).eql([]);
		 * 
		 * //Should call pluralize expect(RiTa.pluralize).to.be.a('function');
		 * 
		 * 
		 * //Should call random let r = RiTa.random(); expect(r).gte(0);
		 * expect(r).lt(1);
		 * 
		 * 
		 * //Should call randomOrdering expect(RiTa.randomOrdering(1)).eql([0]);
		 * 
		 * //Should call randomSeed expect(RiTa.randomSeed).is.a('function');
		 * 
		 * 
		 * //Should call randomWord expect(RiTa.randomWord()).is.a('string');
		 * 
		 * 
		 * //Should call rhymes expect(RiTa.rhymes).to.be.a('function');
		 * 
		 * 
		 * //Should call evaluate expect(RiTa.evaluate('(a | a)')).eq('a');
		 * 
		 * 
		 * //Should call similarBy expect(RiTa.similarBy).to.be.a('function');
		 * 
		 * 
		 * //Should call singularize expect(RiTa.singularize).to.be.a('function');
		 * 
		 * 
		 * //Should call sentences expect(RiTa.sentences).to.be.a('function');
		 * 
		 * 
		 * //Should call stem expect(RiTa.stem("cakes")).eq('cake');
		 * 
		 * 
		 * //Should call tokenize expect(RiTa.tokenize).to.be.a('function');;
		 * 
		 * 
		 * //Should call untokenize expect(RiTa.untokenize).to.be.a('function');
		 * 
		 * 
		 * //Should call words expect(RiTa.words).to.be.a('function');
		 */
	}

}
