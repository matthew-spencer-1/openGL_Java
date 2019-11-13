package com.spentech.opengl.context.item.impl;

import java.util.ArrayList;
import java.util.List;

import com.spentech.opengl.context.item.OpenGLItem;
import com.spentech.opengl.graph.PositionRotationScale;
import com.spentech.opengl.graph.mesh.Mesh;
import com.spentech.opengl.graph.mesh.impl.OpenMeshImpl;
import com.spentech.opengl.utils.VertexArrayParsingMap;

public class ColorTable extends PositionRotationScale implements OpenGLItem {

	private final int TRIANGLE_COUNT = 288;
	private final Mesh mesh;

	public ColorTable() {
		this.mesh = new OpenMeshImpl(generateVertexArray(), generateParsingMap(), TRIANGLE_COUNT);
	}

	@Override
	public Mesh getMesh() {
		return mesh;
	}
	
	private float[] generateVertexArray() {
		return new float[]{
			/* Render Table Top */
			//Position			//Color		(Red vertices, Front)
			-1.0f,  1.0f, -0.5f, 1.0f, 0.0f, 0.0f,
			 1.0f,  1.0f, -0.5f, 1.0f, 0.0f, 0.0f,
			 1.0f,  1.1f, -0.5f, 1.0f, 0.0f, 0.0f,
			 1.0f,  1.1f, -0.5f, 1.0f, 0.0f, 0.0f,
			-1.0f,  1.1f, -0.5f, 1.0f, 0.0f, 0.0f,
			-1.0f,  1.0f, -0.5f, 1.0f, 0.0f, 0.0f,
										//	(Green Vertices, Back)
			-1.0f,  1.0f,  0.5f, 0.0f, 1.0f, 0.0f,
			 1.0f,  1.0f,  0.5f, 0.0f, 1.0f, 0.0f,
			 1.0f,  1.1f,  0.5f, 0.0f, 1.0f, 0.0f,
			 1.0f,  1.1f,  0.5f, 0.0f, 1.0f, 0.0f,
			-1.0f,  1.1f,  0.5f, 0.0f, 1.0f, 0.0f,
			-1.0f,  1.0f,  0.5f, 0.0f, 1.0f, 0.0f,
										//	(Blue Vertices, Left)
			-1.0f,  1.1f,  0.5f, 0.0f, 0.0f, 1.0f,
			-1.0f,  1.1f, -0.5f, 0.0f, 0.0f, 1.0f,
			-1.0f,  1.0f, -0.5f, 0.0f, 0.0f, 1.0f,
			-1.0f,  1.0f, -0.5f, 0.0f, 0.0f, 1.0f,
			-1.0f,  1.0f,  0.5f, 0.0f, 0.0f, 1.0f,
			-1.0f,  1.1f,  0.5f, 0.0f, 0.0f, 1.0f,
										//	(Yellow Vertices, Right)
			 1.0f,  1.1f,  0.5f, 1.0f, 1.0f, 0.0f,
			 1.0f,  1.1f, -0.5f, 1.0f, 1.0f, 0.0f,
			 1.0f,  1.0f, -0.5f, 1.0f, 1.0f, 0.0f,
			 1.0f,  1.0f, -0.5f, 1.0f, 1.0f, 0.0f,
			 1.0f,  1.0f,  0.5f, 1.0f, 1.0f, 0.0f,
			 1.0f,  1.1f,  0.5f, 1.0f, 1.0f, 0.0f,
			 	 	 	 	 	 	 	//	(Teal Vertices, Bottom)
			-1.0f,  1.0f, -0.5f, 0.0f, 1.0f, 1.0f,
			 1.0f,  1.0f, -0.5f, 0.0f, 1.0f, 1.0f,
			 1.0f,  1.0f,  0.5f, 0.0f, 1.0f, 1.0f,
			 1.0f,  1.0f,  0.5f, 0.0f, 1.0f, 1.0f,
			-1.0f,  1.0f,  0.5f, 0.0f, 1.0f, 1.0f,
			-1.0f,  1.0f, -0.5f, 0.0f, 1.0f, 1.0f,
										//	(Purple Vertices, Top)
			-1.0f,  1.1f, -0.5f, 1.0f, 0.0f, 1.0f,
			 1.0f,  1.1f, -0.5f, 1.0f, 0.0f, 1.0f,
			 1.0f,  1.1f,  0.5f, 1.0f, 0.0f, 1.0f,
			 1.0f,  1.1f,  0.5f, 1.0f, 0.0f, 1.0f,
			-1.0f,  1.1f,  0.5f, 1.0f, 0.0f, 1.0f,
			-1.0f,  1.1f, -0.5f, 1.0f, 0.0f, 1.0f,
			/*End Render Table Top */
			/*Render under-support Front*/
			//Position			//Color		(Red vertices, Front)
			-0.3f,  0.9f, -0.48f, 1.0f, 0.0f, 0.0f,
			 0.3f,  0.9f, -0.48f, 1.0f, 0.0f, 0.0f,
			 0.3f,  1.0f, -0.48f, 1.0f, 0.0f, 0.0f,
			 0.3f,  1.0f, -0.48f, 1.0f, 0.0f, 0.0f,
			-0.3f,  1.0f, -0.48f, 1.0f, 0.0f, 0.0f,
			-0.3f,  0.9f, -0.48f, 1.0f, 0.0f, 0.0f,
										//	(Green Vertices, Back)
			-0.3f,  0.9f, -0.38f, 0.0f, 1.0f, 0.0f,
			 0.3f,  0.9f, -0.38f, 0.0f, 1.0f, 0.0f,
			 0.3f,  1.0f, -0.38f, 0.0f, 1.0f, 0.0f,
			 0.3f,  1.0f, -0.38f, 0.0f, 1.0f, 0.0f,
			-0.3f,  1.0f, -0.38f, 0.0f, 1.0f, 0.0f,
			-0.3f,  0.9f, -0.38f, 0.0f, 1.0f, 0.0f,
										//	(Blue Vertices, Left)
			-0.3f,  1.0f, -0.38f, 0.0f, 0.0f, 1.0f,
			-0.3f,  1.0f, -0.48f, 0.0f, 0.0f, 1.0f,
			-0.3f,  0.9f, -0.48f, 0.0f, 0.0f, 1.0f,
			-0.3f,  0.9f, -0.48f, 0.0f, 0.0f, 1.0f,
			-0.3f,  0.9f, -0.38f, 0.0f, 0.0f, 1.0f,
			-0.3f,  1.0f, -0.38f, 0.0f, 0.0f, 1.0f,
										//	(Yellow Vertices, Right)
			 0.3f,  1.0f, -0.38f, 1.0f, 1.0f, 0.0f,
			 0.3f,  1.0f, -0.48f, 1.0f, 1.0f, 0.0f,
			 0.3f,  0.9f, -0.48f, 1.0f, 1.0f, 0.0f,
			 0.3f,  0.9f, -0.48f, 1.0f, 1.0f, 0.0f,
			 0.3f,  0.9f, -0.38f, 1.0f, 1.0f, 0.0f,
			 0.3f,  1.0f, -0.38f, 1.0f, 1.0f, 0.0f,
										//	(Teal Vertices, Bottom)
			-0.3f,  0.9f, -0.48f, 0.0f, 1.0f, 1.0f,
			 0.3f,  0.9f, -0.48f, 0.0f, 1.0f, 1.0f,
			 0.3f,  0.9f, -0.38f, 0.0f, 1.0f, 1.0f,
			 0.3f,  0.9f, -0.38f, 0.0f, 1.0f, 1.0f,
			-0.3f,  0.9f, -0.38f, 0.0f, 1.0f, 1.0f,
			-0.3f,  0.9f, -0.48f, 0.0f, 1.0f, 1.0f,
										//	(Purple Vertices, Top)
			-0.3f,  1.0f, -0.48f, 1.0f, 0.0f, 1.0f,
			 0.3f,  1.0f, -0.48f, 1.0f, 0.0f, 1.0f,
			 0.3f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			 0.3f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			-0.3f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			-0.3f,  1.0f, -0.48f, 1.0f, 0.0f, 1.0f,
			/*End Render under-support Front*/

			/*Render Left inside Leg */
			//Position			//Color		//	(Green Vertices, Back)
			-0.8f, -0.9f,  0.48f, 0.0f, 1.0f, 0.0f,
			-0.7f, -0.9f,  0.48f, 0.0f, 1.0f, 0.0f,
			-0.7f,  1.0f, -0.28f, 0.0f, 1.0f, 0.0f,
			-0.7f,  1.0f, -0.28f, 0.0f, 1.0f, 0.0f,
			-0.8f,  1.0f, -0.28f, 0.0f, 1.0f, 0.0f,
			-0.8f, -0.9f,  0.48f, 0.0f, 1.0f, 0.0f,
										// (Red vertices, Front)
			-0.8f, -0.9f,  0.38f, 1.0f, 0.0f, 0.0f,
			-0.7f, -0.9f,  0.38f, 1.0f, 0.0f, 0.0f,
			-0.7f,  1.0f, -0.38f, 1.0f, 0.0f, 0.0f,
			-0.7f,  1.0f, -0.38f, 1.0f, 0.0f, 0.0f,
			-0.8f,  1.0f, -0.38f, 1.0f, 0.0f, 0.0f,
			-0.8f, -0.9f,  0.38f, 1.0f, 0.0f, 0.0f,
										//	(Blue Vertices, Left)
			-0.8f,  1.0f, -0.28f, 0.0f, 0.0f, 1.0f,
			-0.8f,  1.0f, -0.38f, 0.0f, 0.0f, 1.0f,
			-0.8f, -0.9f,  0.38f, 0.0f, 0.0f, 1.0f,
			-0.8f, -0.9f,  0.38f, 0.0f, 0.0f, 1.0f,
			-0.8f, -0.9f,  0.48f, 0.0f, 0.0f, 1.0f,
			-0.8f,  1.0f, -0.28f, 0.0f, 0.0f, 1.0f,
										//	(Yellow Vertices, Right)
			-0.7f,  1.0f, -0.28f, 1.0f, 1.0f, 0.0f,
			-0.7f,  1.0f, -0.38f, 1.0f, 1.0f, 0.0f,
			-0.7f, -0.9f,  0.38f, 1.0f, 1.0f, 0.0f,
			-0.7f, -0.9f,  0.38f, 1.0f, 1.0f, 0.0f,
			-0.7f, -0.9f,  0.48f, 1.0f, 1.0f, 0.0f,
			-0.7f,  1.0f, -0.28f, 1.0f, 1.0f, 0.0f,
										//	(Teal Vertices, Bottom)
			-0.8f, -0.9f,  0.38f, 0.0f, 1.0f, 1.0f,
			-0.7f, -0.9f,  0.38f, 0.0f, 1.0f, 1.0f,
			-0.7f, -0.9f,  0.48f, 0.0f, 1.0f, 1.0f,
			-0.7f, -0.9f,  0.48f, 0.0f, 1.0f, 1.0f,
			-0.8f, -0.9f,  0.48f, 0.0f, 1.0f, 1.0f,
			-0.8f, -0.9f,  0.38f, 0.0f, 1.0f, 1.0f,
										//	(Purple Vertices, Top)
			-0.8f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			-0.7f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			-0.7f,  1.0f, -0.28f, 1.0f, 0.0f, 1.0f,
			-0.7f,  1.0f, -0.28f, 1.0f, 0.0f, 1.0f,
			-0.8f,  1.0f, -0.28f, 1.0f, 0.0f, 1.0f,
			-0.8f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			/*End Render Left Inside Leg */

			/*Render Left outside Leg */
			//Position			//Color
			//	(Green Vertices, Back)
			-0.8f, -0.9f, -0.28f, 0.0f, 1.0f, 0.0f,
			-0.9f, -0.9f, -0.28f, 0.0f, 1.0f, 0.0f,
			-0.9f,  1.0f,  0.48f, 0.0f, 1.0f, 0.0f,
			-0.9f,  1.0f,  0.48f, 0.0f, 1.0f, 0.0f,
			-0.8f,  1.0f,  0.48f, 0.0f, 1.0f, 0.0f,
			-0.8f, -0.9f, -0.28f, 0.0f, 1.0f, 0.0f,
			//(Red vertices, Front)
			-0.8f, -0.9f, -0.38f, 1.0f, 0.0f, 0.0f,
			-0.9f, -0.9f, -0.38f, 1.0f, 0.0f, 0.0f,
			-0.9f,  1.0f,  0.38f, 1.0f, 0.0f, 0.0f,
			-0.9f,  1.0f,  0.38f, 1.0f, 0.0f, 0.0f,
			-0.8f,  1.0f,  0.38f, 1.0f, 0.0f, 0.0f,
			-0.8f, -0.9f, -0.38f, 1.0f, 0.0f, 0.0f,

										//	(Blue Vertices, Left)
			-0.9f,  1.0f,  0.48f, 0.0f, 0.0f, 1.0f,
			-0.9f,  1.0f,  0.38f, 0.0f, 0.0f, 1.0f,
			-0.9f, -0.9f, -0.38f, 0.0f, 0.0f, 1.0f,
			-0.9f, -0.9f, -0.38f, 0.0f, 0.0f, 1.0f,
			-0.9f, -0.9f, -0.28f, 0.0f, 0.0f, 1.0f,
			-0.9f,  1.0f,  0.48f, 0.0f, 0.0f, 1.0f,
										//	(Yellow Vertices, Right)
			-0.8f,  1.0f,  0.48f, 1.0f, 1.0f, 0.0f,
			-0.8f,  1.0f,  0.38f, 1.0f, 1.0f, 0.0f,
			-0.8f, -0.9f, -0.38f, 1.0f, 1.0f, 0.0f,
			-0.8f, -0.9f, -0.38f, 1.0f, 1.0f, 0.0f,
			-0.8f, -0.9f, -0.28f, 1.0f, 1.0f, 0.0f,
			-0.8f,  1.0f,  0.48f, 1.0f, 1.0f, 0.0f,
										//	(Teal Vertices, Bottom)
			-0.8f, -0.9f, -0.38f, 0.0f, 1.0f, 1.0f,
			-0.9f, -0.9f, -0.38f, 0.0f, 1.0f, 1.0f,
			-0.9f, -0.9f, -0.28f, 0.0f, 1.0f, 1.0f,
			-0.9f, -0.9f, -0.28f, 0.0f, 1.0f, 1.0f,
			-0.8f, -0.9f, -0.28f, 0.0f, 1.0f, 1.0f,
			-0.8f, -0.9f, -0.38f, 0.0f, 1.0f, 1.0f,
										//	(Purple Vertices, Top)
			-0.8f,  1.0f,  0.38f, 1.0f, 0.0f, 1.0f,
			-0.9f,  1.0f,  0.38f, 1.0f, 0.0f, 1.0f,
			-0.9f,  1.0f,  0.48f, 1.0f, 0.0f, 1.0f,
			-0.9f,  1.0f,  0.48f, 1.0f, 0.0f, 1.0f,
			-0.8f,  1.0f,  0.48f, 1.0f, 0.0f, 1.0f,
			-0.8f,  1.0f,  0.38f, 1.0f, 0.0f, 1.0f,
			/*End Render Left Outside Leg */


			/*Render Right Inside Leg */
			//Position			//Color		//	(Green Vertices, Back)
			 0.8f, -0.9f,  0.48f, 0.0f, 1.0f, 0.0f,
			 0.7f, -0.9f,  0.48f, 0.0f, 1.0f, 0.0f,
			 0.7f,  1.0f, -0.28f, 0.0f, 1.0f, 0.0f,
			 0.7f,  1.0f, -0.28f, 0.0f, 1.0f, 0.0f,
			 0.8f,  1.0f, -0.28f, 0.0f, 1.0f, 0.0f,
			 0.8f, -0.9f,  0.48f, 0.0f, 1.0f, 0.0f,
			 	 	 	 	 	 	 	 	 //(Red vertices, Front)
			 0.8f, -0.9f,  0.38f, 1.0f, 0.0f, 0.0f,
			 0.7f, -0.9f,  0.38f, 1.0f, 0.0f, 0.0f,
			 0.7f,  1.0f, -0.38f, 1.0f, 0.0f, 0.0f,
			 0.7f,  1.0f, -0.38f, 1.0f, 0.0f, 0.0f,
			 0.8f,  1.0f, -0.38f, 1.0f, 0.0f, 0.0f,
			 0.8f, -0.9f,  0.38f, 1.0f, 0.0f, 0.0f,
										//	(Blue Vertices, Left)
			 0.7f,  1.0f, -0.28f, 0.0f, 0.0f, 1.0f,
			 0.7f,  1.0f, -0.38f, 0.0f, 0.0f, 1.0f,
			 0.7f, -0.9f,  0.38f, 0.0f, 0.0f, 1.0f,
			 0.7f, -0.9f,  0.38f, 0.0f, 0.0f, 1.0f,
			 0.7f, -0.9f,  0.48f, 0.0f, 0.0f, 1.0f,
			 0.7f,  1.0f, -0.28f, 0.0f, 0.0f, 1.0f,
										//	(Yellow Vertices, Right)
			 0.8f,  1.0f, -0.28f, 1.0f, 1.0f, 0.0f,
			 0.8f,  1.0f, -0.38f, 1.0f, 1.0f, 0.0f,
			 0.8f, -0.9f,  0.38f, 1.0f, 1.0f, 0.0f,
			 0.8f, -0.9f,  0.38f, 1.0f, 1.0f, 0.0f,
			 0.8f, -0.9f,  0.48f, 1.0f, 1.0f, 0.0f,
			 0.8f,  1.0f, -0.28f, 1.0f, 1.0f, 0.0f,
										//	(Teal Vertices, Bottom)
			 0.8f, -0.9f,  0.38f, 0.0f, 1.0f, 1.0f,
			 0.7f, -0.9f,  0.38f, 0.0f, 1.0f, 1.0f,
			 0.7f, -0.9f,  0.48f, 0.0f, 1.0f, 1.0f,
			 0.7f, -0.9f,  0.48f, 0.0f, 1.0f, 1.0f,
			 0.8f, -0.9f,  0.48f, 0.0f, 1.0f, 1.0f,
			 0.8f, -0.9f,  0.38f, 0.0f, 1.0f, 1.0f,
										//	(Purple Vertices, Top)
			 0.8f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			 0.7f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			 0.7f,  1.0f, -0.28f, 1.0f, 0.0f, 1.0f,
			 0.7f,  1.0f, -0.28f, 1.0f, 0.0f, 1.0f,
			 0.8f,  1.0f, -0.28f, 1.0f, 0.0f, 1.0f,
			 0.8f,  1.0f, -0.38f, 1.0f, 0.0f, 1.0f,
			/*End Render Right inside Leg */

			 /*Render Left outside Leg */
			//Position			//Color		(Red vertices, Front)
			 0.9f, -0.9f, -0.38f, 1.0f, 0.0f, 0.0f,
			 0.8f, -0.9f, -0.38f, 1.0f, 0.0f, 0.0f,
			 0.8f,  1.0f,  0.38f, 1.0f, 0.0f, 0.0f,
			 0.8f,  1.0f,  0.38f, 1.0f, 0.0f, 0.0f,
			 0.9f,  1.0f,  0.38f, 1.0f, 0.0f, 0.0f,
			 0.9f, -0.9f, -0.38f, 1.0f, 0.0f, 0.0f,
										//	(Green Vertices, Back)
			 0.9f, -0.9f, -0.28f, 0.0f, 1.0f, 0.0f,
			 0.8f, -0.9f, -0.28f, 0.0f, 1.0f, 0.0f,
			 0.8f,  1.0f,  0.48f, 0.0f, 1.0f, 0.0f,
			 0.8f,  1.0f,  0.48f, 0.0f, 1.0f, 0.0f,
			 0.9f,  1.0f,  0.48f, 0.0f, 1.0f, 0.0f,
			 0.9f, -0.9f, -0.28f, 0.0f, 1.0f, 0.0f,
										//	(Blue Vertices, Left)
			 0.8f,  1.0f,  0.48f, 0.0f, 0.0f, 1.0f,
			 0.8f,  1.0f,  0.38f, 0.0f, 0.0f, 1.0f,
			 0.8f, -0.9f, -0.38f, 0.0f, 0.0f, 1.0f,
			 0.8f, -0.9f, -0.38f, 0.0f, 0.0f, 1.0f,
			 0.8f, -0.9f, -0.28f, 0.0f, 0.0f, 1.0f,
			 0.8f,  1.0f,  0.48f, 0.0f, 0.0f, 1.0f,
										//	(Yellow Vertices, Right)
			 0.9f,  1.0f,  0.48f, 1.0f, 1.0f, 0.0f,
			 0.9f,  1.0f,  0.38f, 1.0f, 1.0f, 0.0f,
			 0.9f, -0.9f, -0.38f, 1.0f, 1.0f, 0.0f,
			 0.9f, -0.9f, -0.38f, 1.0f, 1.0f, 0.0f,
			 0.9f, -0.9f, -0.28f, 1.0f, 1.0f, 0.0f,
			 0.9f,  1.0f,  0.48f, 1.0f, 1.0f, 0.0f,
										//	(Teal Vertices, Bottom)
			 0.9f, -0.9f, -0.38f, 1.0f, 1.0f, 1.0f,
			 0.8f, -0.9f, -0.38f, 0.0f, 1.0f, 1.0f,
			 0.8f, -0.9f, -0.28f, 0.0f, 1.0f, 1.0f,
			 0.8f, -0.9f, -0.28f, 0.0f, 1.0f, 1.0f,
			 0.9f, -0.9f, -0.28f, 0.0f, 1.0f, 1.0f,
			 0.9f, -0.9f, -0.38f, 0.0f, 1.0f, 1.0f,
										//	(Purple Vertices, Top)
			 0.9f,  1.0f,  0.38f, 1.0f, 0.0f, 1.0f,
			 0.8f,  1.0f,  0.38f, 1.0f, 0.0f, 1.0f,
			 0.8f,  1.0f,  0.48f, 1.0f, 0.0f, 1.0f,
			 0.8f,  1.0f,  0.48f, 1.0f, 0.0f, 1.0f,
			 0.9f,  1.0f,  0.48f, 1.0f, 0.0f, 1.0f,
			 0.9f,  1.0f,  0.38f, 1.0f, 0.0f, 1.0f,
			/*End Render Left Outside Leg */
        };
	}
	
	private List<VertexArrayParsingMap> generateParsingMap(){
		
		// The sizes of the vertex and color components
        final int sizeVertex = 3;
        final int sizeColor  = 3;
        
        // The 'stride' is the sum of the sizes of individual components
        final int stride = sizeVertex + sizeColor;
        
        // The 'offset is the number of bytes from the start of the tuple
        final long offsetVertex = 0;
        final long offsetColor  = 3;
        
        VertexArrayParsingMap vertexMap = new VertexArrayParsingMap(sizeVertex, offsetVertex, stride);
        VertexArrayParsingMap colorMap = new VertexArrayParsingMap(sizeColor, offsetColor, stride );
        
        List<VertexArrayParsingMap> list = new ArrayList<>();
        list.add(vertexMap);
        list.add(colorMap);
        
        return list;
	}
}
