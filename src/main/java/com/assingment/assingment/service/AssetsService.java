package com.assingment.assingment.service;

import org.springframework.stereotype.Service;

import com.assingment.assingment.model.Assets;

@Service
public class AssetsService {
	
	private Assets asset;
	int catId;
	public Assets getAsset() {
		return asset;
	}

	public void setAsset(Assets asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "AssetRequest [asset=" + asset + "]";
	}
	

}
