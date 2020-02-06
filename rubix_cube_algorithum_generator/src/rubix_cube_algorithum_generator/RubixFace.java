package rubix_cube_algorithum_generator;

public class RubixFace {
	// a rubix face is simply a 3x3 with pointers to the other
	// 4 adjacent sides and can swap their chars with commands
	
	// these are not the names of the final rubix cube reference points
	// these are just from the perspective of the face in question
	// only the rubixface with the actual name face is the final reference
	
	// the references are based on the 2d lower case t pose 
	
	//     []
	//   [][][]
	//     []
	//     []
	
	public char[][] face;
	
	public char[] left; // read bottom to top
	public char[] right; // read top to bottom
	public char[] top; // read left to right
	public char[] bottom; // read right to left
	
	public RubixFace(char[][] face, char[] left, char[] right, char[] top, char[] bottom) {
		this.face = face;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
	}
	
	public void rotate(int degree) {
		if(degree == 1) {
			rotate90();
		}
		if(degree == 2) {
			rotate180();
		}
		if(degree == 3) {
			rotate270();
		}
	}
	
	public void rotate90() {
		// we shift left to top, top to right, right to bottom, bottom to left
		char[] tempSide = right;
		right = top;
		top = left;
		left = bottom;
		bottom = tempSide;
		// now rotate the 3x3
		char tempCorner = face[0][0];
		face[0][0] = face[2][0];
		face[2][0] = face[2][2];
		face[2][2] = face[0][2];
		face[0][2] = tempCorner;
		
		char tempEdge = face[0][1];
		face[0][1] = face[1][0];
		face[1][0] = face[2][1];
		face[2][1] = face[1][2];
		face[1][2] = tempEdge;
	}
	
	public void rotate180() {
		
	}
	
	public void rotate270() {
		
	}
	
}
