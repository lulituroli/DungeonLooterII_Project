package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Game;

public class DLLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = Game.TITLE;
		config.width = Game.V_WIDTH * Game.SCALE;
		config.height = Game.V_HEIGHT * Game.SCALE;
		
		
		new LwjglApplication(new Game(), config);
		
		
	}
}
