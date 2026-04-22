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
	
	@Test
	void test_spare() {
		game.roll(7);
		game.roll(3);
		game.roll(4);
		throwBall(17,0); 
		assertEquals(18,game.score());
	}
	
	@Test
	void test_strike() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		throwBall(16,0);
		assertEquals(24,game.score());
	}
	
	@Test 
	void test_cas_general() {
		game.roll(1);
		game.roll(2);
		game.roll(10);
		game.roll(0);
		game.roll(10);
		game.roll(4);
		game.roll(2);
		game.roll(0);
		game.roll(10);
		game.roll(6);
		game.roll(2);
		game.roll(0);
		game.roll(10);
		game.roll(6);
		game.roll(4);
		game.roll(8);
		game.roll(2);
		game.roll(2);
		game.roll(7);
		assertEquals(122, game.score());
	}
	
	@Test
	void test_extension() {
		int[] roll = {1, 2, 10, 0, 10, 4, 2, 0, 10, 6, 2, 0, 10, 6, 4, 8, 2, 2, 8, 8};
		for(int i=0; i < roll.length; i++) 
			game.roll(roll[i]);
		assertEquals(131, game.score());
	}
	

	@Test
	void test_genie() {
		throwBall(12,10);
		assertEquals(300, game.score());
	}
	
	private void throwBall(int nbFois, int nbQuilleTombee) {
		for( int i = 0; i < nbFois; i++) {
			game.roll(nbQuilleTombee );
		}
	}

}
