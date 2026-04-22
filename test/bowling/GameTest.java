package bowling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	Game game;
	
	@BeforeEach
	void init() {
		game = new Game();
	}
	@Test
	void test_aucune_quille() {
	    throwBall(20,0);
		assertEquals(0,game.score());
	}
	@Test
	void test_vint_un() {
		throwBall(20,1);
		assertEquals(20,game.score());
	}
	
	@Test
	void test_dix_un_dix_deux() {
		throwBall(10,1);
		throwBall(10,2);
		assertEquals(30,game.score());
	}
	
	private void throwBall(int nbFois, int nbQuilleTombee) {
		for( int i = 0; i < nbFois; i++) {
			game.roll(nbQuilleTombee );
		}
	}

}
