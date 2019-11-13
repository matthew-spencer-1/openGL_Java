package com.spentech.opengl.utils;

import java.util.HashMap;

public class VertexArrayParsingMap extends HashMap<String, Long> {

	private static final long serialVersionUID = 5420325938986687072L;
	
	private final int sizeOfFloat = Float.SIZE / Byte.SIZE;
	private final String SIZE_KEY = "size";
	private final String OFFSET_KEY = "offset";
	private final String STRIDE_KEY = "stride";
	
	public VertexArrayParsingMap() {
		
	}
	
	public VertexArrayParsingMap(long elementCount, long offset, long stride) {
		super.put(SIZE_KEY, elementCount);
		super.put(OFFSET_KEY, new Long(offset));
		super.put(STRIDE_KEY, stride);
	}
	
	public void setElementCount(long elementCount) {
		super.put(SIZE_KEY, elementCount);
	}
	
	public int getElementCount() {
		return super.get(SIZE_KEY).intValue();
	}
	
	public void setOffset(long offset) {
		super.put(OFFSET_KEY, offset);
	}
	
	public long getOffset() {
		return super.get(OFFSET_KEY) * sizeOfFloat;
	}
	
	public void setStride(long stride) {
		super.put(STRIDE_KEY, stride);
	}
	
	public int getStride() {
		return super.get(STRIDE_KEY).intValue() * sizeOfFloat ;
	}
}
