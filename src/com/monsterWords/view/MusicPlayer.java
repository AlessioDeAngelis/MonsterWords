package com.monsterWords.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MusicPlayer {

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final MusicPlayer INSTANCE = new MusicPlayer();
	}

	public static MusicPlayer getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private Music soundtrack;
	private Sound soundPop, soundWrong;
	private Sound[] sounds;

	private MusicPlayer() {
		this.soundPop = Gdx.audio.newSound(Gdx.files.internal("sound/pop.mp3"));
		this.soundWrong = Gdx.audio.newSound(Gdx.files.internal("sound/wrong.mp3"));
		this.soundtrack = Gdx.audio.newMusic(Gdx.files.internal("music/soundtrack.mp3"));
		this.sounds = new Sound[] { soundPop, soundWrong };
	}

	public void playSoundPop() {
		this.soundPop.play(1);
	}

	public void playSoundWrong() {
		this.soundWrong.play();
	}
	
	public void playSoundtrack(){
		this.soundtrack.setLooping(true);
		this.soundtrack.play();
	}

	public void dispose() {
		soundtrack.dispose();
		for (Sound sound : sounds) {
			sound.dispose();
		}
	}

}
