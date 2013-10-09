package com.monsterWords.utils;

import com.badlogic.gdx.assets.AssetManager;

public class AssetLoader {

	private AssetManager manager;

	private static class SingletonHolder {
		public static final AssetLoader INSTANCE = new AssetLoader();
	}

	private AssetLoader() {

	}

	public static AssetLoader getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public AssetManager getManager() {
		return manager;
	}

	public void setManager(AssetManager manager) {
		this.manager = manager;
	}

}
