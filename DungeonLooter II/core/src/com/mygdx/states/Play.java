package com.mygdx.states;

import static com.mygdx.handlers.B2DVars.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Game;
import com.mygdx.handlers.GameStateManager;


public class Play extends GameState {
	
	private World world;
	private Box2DDebugRenderer b2dr;
	private OrthographicCamera b2dCam;

	public Play (GameStateManager gsm) {
		
		super (gsm);
		
		world = new World (new Vector2 (0, -6f), true);
		b2dr = new Box2DDebugRenderer();
		
		
		
		//create wall
		BodyDef bdef = new BodyDef ();
		bdef.position.set (160/PPM, 120/PPM);
		bdef.type = BodyType.StaticBody;
		Body body = world.createBody(bdef);
		
		
		PolygonShape shape = new PolygonShape ();
		shape.setAsBox (50/PPM,  5/PPM);	
		FixtureDef fdef = new FixtureDef ();
		fdef.shape = shape;
		body.createFixture (fdef);
		
		//create box
		bdef.position.set (160/PPM, 200/PPM);
		bdef.type = BodyType.DynamicBody;
		body = world.createBody (bdef);
		
		shape.setAsBox (5/PPM,5/PPM);
		fdef.shape = shape;
		fdef.restitution = 0.8f;
		body.createFixture (fdef);
		
		
		//create 1 2. box
				bdef.position.set (155/PPM, 300/PPM);
				bdef.type = BodyType.DynamicBody;
				body = world.createBody (bdef);
				
				shape.setAsBox (5/PPM,5/PPM);
				fdef.shape = shape;
				fdef.restitution = 0.8f;
				body.createFixture (fdef);
				
		//create ball
				bdef.position.set (160/PPM, 200/PPM);
				bdef.type = BodyType.DynamicBody;
				
		
		
		//body.applyForce (new Vector2(500, -100000), body.getPosition(), false);
		
		
		
		
		
		//set b2d cam
		
		b2dCam = new OrthographicCamera ();
		b2dCam.setToOrtho(false, Game.V_WIDTH / PPM, Game.V_HEIGHT / PPM);
		
		
	}

	
	public void handleInput() {}
	
	
	
	public void update (float dt) {
		world.step (dt, 6, 2);

	}
	
	
	public void render () {
		
		//clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		b2dr.render (world, b2dCam.combined);
	}
	public void dispose () {}
}
