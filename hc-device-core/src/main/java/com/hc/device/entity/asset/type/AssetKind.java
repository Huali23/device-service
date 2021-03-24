package com.hc.device.entity.asset.type;

public enum AssetKind {	
	
	SPACE,
	DEVICE,
	SERVICE,
	PROBE,
	CONTROL;

	private String canonicalName;
	
	AssetKind() {
		StringBuilder sb = new StringBuilder(name().toLowerCase());
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		canonicalName = sb.toString(); 
	}
	
	public String canonicalName() {
		return canonicalName;
	}
}
