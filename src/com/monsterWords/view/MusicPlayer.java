package com.monsterWords.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.monsterWords.utils.AssetLoader;

public class MusicPlayer {

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final MusicPlayer INSTANCE = new MusicPlayer();
	}
//
	public static MusicPlayer getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private Music soundtrack;
	private Sound soundPop, soundWrong, soundCorrect,soundSelect;
	private Sound[] sounds;
	private AssetManager manager;

	private MusicPlayer() {
		this.soundPop = Gdx.audio.newSound(Gdx.files.internal("sound/pop.mp3"));
		this.soundWrong = Gdx.audio.newSound(Gdx.files.internal("sound/wrong.mp3"));
		this.soundtrack = Gdx.audio.newMusic(Gdx.files.internal("music/soundtrack.ogg"));
		this.soundCorrect = Gdx.audio.newSound(Gdx.files.internal("sound/correctAnswer.mp3"));
		this.soundSelect = Gdx.audio.newSound(Gdx.files.internal("sound/select.wav"));
		this.sounds = new Sound[] { soundPop, soundWrong, soundCorrect,soundSelect };
//		manager = AssetLoader.getInstance().getManager();
//		if(manager.isLoaded("music/soundtrack.ogg")) {
//			   // texture is available, let's fetch it and do do something interesting
//			   this.soundtrack = manager.get("music/soundtrack.ogg", Sound.class);
//			}
//		this.soundtrack = Gdx.audio.newSound(Gdx.files.internal("music/soundtrack.ogg"));
	}

	public void playSoundPop() {
		this.soundPop.play(1);
	}

	public void playSoundCorrect() {
		this.soundCorrect.play(1);
	}

	public void playSoundWrong() {
		this.soundWrong.play();
	}
	
	public void playSoundSelect() {
		this.soundSelect.play();
	}

	public void playSoundtrack() {
		if (this.soundtrack != null) {// sometimes is not loaded at the first
										// time
			this.soundtrack.play();
//			if(this.soundtrack.isPlaying()){
//			this.soundtrack.setLooping(true);
//			}
//			long id = this.soundtrack.play();
//			this.soundtrack.setLooping(id, true);
		}
	}

	public void stopSoundtrack() {
		if (this.soundtrack != null) {
			this.soundtrack.stop();
		}
	}

	public void dispose() {
		if (this.soundtrack != null) {
			soundtrack.dispose();
		}
		for (Sound sound : sounds) {
			sound.dispose();
		}
//		this.manager.unload("music/soundtrack.ogg");
	}

	public void pauseSoundtrack() {
		if(this.soundtrack!=null && this.soundtrack.isPlaying()){
			this.soundtrack.pause();
		}
	}

}
