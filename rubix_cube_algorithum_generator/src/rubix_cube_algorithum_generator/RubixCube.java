package rubix_cube_algorithum_generator;

public class RubixCube {
	
	public char[][] front;
	public char[][] back;
	public char[][] left;
	public char[][] right;
	public char[][] top;
	public char[][] bottom;
	
	
	// to visualize the lay out the squares are arranged like a unfolded lower case
	// t pose with the front in the cross hairs, the chars are read left to right, 
	// top to bottom
	
	//     [to]
	// [le][fr][ri]
	//     [bo]
	//     [ba]
	
	public RubixCube () {
		
	}
	
	public void setConditions(char[][] front, char[][] back, char[][] left, char[][] right, char[][] top, char[][] bottom) {
		this.front = front;
		this.back = back;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
	}
	
	// each face can be rotated based of a value range of 1,2,3 each representing a 90, 180, 270 degree
	// turn clockwise
	
	public void rotateFace(int face, int degree) {
		if(face == 0) {
			rotateFront(degree);
		}
		else if(face == 1) {
			rotateLeft(degree);
		}
		else if(face == 2) {
			rotateRight(degree);
		}
		else if(face == 3) {
			rotateTop(degree);
		}
		else if(face == 4) {
			rotateBottom(degree);
		}
		else if(face == 5) {
			rotateBack(degree);
		}
	}
	
	public void rotateFront(int degree) { // degree is just 1, 2, 3
		char[] tempSide = new char[3];
		if(degree == 1) {
			tempSide[0] = top[2][0];
			tempSide[1] = top[2][1];
			tempSide[2] = top[2][2];
			
			top[2][0] = left[2][2];
			top[2][1] = left[1][2];
			top[2][2] = left[0][2];
			
			left[2][2] = bottom[0][2];
			left[1][2] = bottom[0][1];
			left[0][2] = bottom[0][0];
			
			bottom[0][2] = right[0][0];
			bottom[0][1] = right[1][0];
			bottom[0][0] = right[2][0];
			
			right[0][0] = tempSide[0];
			right[1][0] = tempSide[1];
			right[2][0] = tempSide[2];
			
			char tempCorner = front[0][0];
			front[0][0] = front[2][0];
			front[2][0] = front[2][2];
			front[2][2] = front[0][2];
			front[0][2] = tempCorner;
			
			char tempEdge = front[0][1];
			front[0][1] = front[1][0];
			front[1][0] = front[2][1];
			front[2][1] = front[1][2];
			front[1][2] = tempEdge;
		}
		if(degree == 2) {
			tempSide[0] = bottom[0][2];
			tempSide[1] = bottom[0][1];
			tempSide[2] = bottom[0][0];
			
			bottom[0][2] = top[2][0];
			bottom[0][1] = top[2][1];
			bottom[0][0] = top[2][2];
			
			top[2][0] = tempSide[0];
			top[2][1] = tempSide[1];
			top[2][2] = tempSide[2];
			
			tempSide[0] = left[2][2];
			tempSide[1] = left[1][2];
			tempSide[2] = left[0][2];
			
			left[2][2] = right[0][0];
			left[1][2] = right[1][0];
			left[0][2] = right[2][0];
			
			right[0][0] = tempSide[0];
			right[1][0] = tempSide[1];
			right[2][0] = tempSide[2];
			
			char tempCorner = front[0][0];
			front[0][0] = front[2][2];
			front[2][2] = tempCorner;
			
			tempCorner = front[0][2];
			front[0][2] = front[2][0];
			front[2][0] = tempCorner;
			
			char tempEdge = front[0][1];
			front[0][1] = front[2][1];
			front[2][1] = tempEdge;
			
			tempEdge = front[1][0];
			front[1][0] = front[1][2];
			front[1][2] = tempEdge;
		}
		if(degree == 3) {
			tempSide[0] = top[2][0];
			tempSide[1] = top[2][1];
			tempSide[2] = top[2][2];
			
			top[2][0] = right[0][0];
			top[2][1] = right[1][0];
			top[2][2] = right[2][0];
			
			right[0][0] = bottom[0][2];
			right[1][0] = bottom[0][1];
			right[2][0] = bottom[0][0];
			
			bottom[0][2] = left[2][2];
			bottom[0][1] = left[1][2];
			bottom[0][0] = left[0][2];
			
			left[2][2] = tempSide[0];
			left[1][2] = tempSide[1];
			left[0][2] = tempSide[2];
			
			char tempCorner = front[0][0];
			front[0][0] = front[0][2];
			front[0][2] = front[2][2];
			front[2][2] = front[2][0];
			front[2][0] = tempCorner;
			
			char tempEdge = front[0][1];
			front[0][1] = front[1][2];
			front[1][2] = front[2][1];
			front[2][1] = front[1][0];
			front[1][0] = tempEdge;
		}
	}
	
	public void rotateTop(int degree) { // degree is just 1, 2, 3
		char[] tempSide = new char[3];
		if(degree == 1) {
			tempSide[0] = back[2][0];
			tempSide[1] = back[2][1];
			tempSide[2] = back[2][2];
			
			back[2][0] = left[0][2];
			back[2][1] = left[0][1];
			back[2][2] = left[0][0];
			
			left[0][2] = front[0][2];
			left[0][1] = front[0][1];
			left[0][0] = front[0][0];
			
			front[0][2] = right[0][2];
			front[0][1] = right[0][1];
			front[0][0] = right[0][0];
			
			right[0][2] = tempSide[0];
			right[0][1] = tempSide[1];
			right[0][0] = tempSide[2];
			
			char tempCorner = top[0][0];
			top[0][0] = top[2][0];
			top[2][0] = top[2][2];
			top[2][2] = top[0][2];
			top[0][2] = tempCorner;
			
			char tempEdge = top[0][1];
			top[0][1] = top[1][0];
			top[1][0] = top[2][1];
			top[2][1] = top[1][2];
			top[1][2] = tempEdge;
		}
		if(degree == 2) {
			tempSide[0] = back[2][0];
			tempSide[1] = back[2][1];
			tempSide[2] = back[2][2];
			
			back[2][0] = front[0][2];
			back[2][1] = front[0][1];
			back[2][2] = front[0][0];
			
			front[0][2] = tempSide[0];
			front[0][1] = tempSide[1];
			front[0][0] = tempSide[2];
			
			tempSide[0] = left[0][2];
			tempSide[1] = left[0][1];
			tempSide[2] = left[0][0];
			
			left[0][2] = right[0][2];
			left[0][1] = right[0][1];
			left[0][0] = right[0][0];
			
			right[0][2] = tempSide[0];
			right[0][1] = tempSide[1];
			right[0][0] = tempSide[2];
			
			char tempCorner = top[0][0];
			top[0][0] = top[2][2];
			top[2][2] = tempCorner;
			
			tempCorner = top[0][2];
			top[0][2] = top[2][0];
			top[2][0] = tempCorner;
			
			char tempEdge = top[0][1];
			top[0][1] = top[2][1];
			top[2][1] = tempEdge;
			
			tempEdge = top[1][0];
			top[1][0] = top[1][2];
			top[1][2] = tempEdge;
		}
		if(degree == 3) {
			tempSide[0] = back[2][0];
			tempSide[1] = back[2][1];
			tempSide[2] = back[2][2];
			
			back[2][0] = right[0][2];
			back[2][1] = right[0][1];
			back[2][2] = right[0][0];
			
			right[0][2] = front[0][2];
			right[0][1] = front[0][1];
			right[0][0] = front[0][0];
			
			front[0][2] = left[0][2];
			front[0][1] = left[0][1];
			front[0][0] = left[0][0];
			
			left[0][2] = tempSide[0];
			left[0][1] = tempSide[1];
			left[0][0] = tempSide[2];
			
			char tempCorner = top[0][0];
			top[0][0] = top[0][2];
			top[0][2] = top[2][2];
			top[2][2] = top[2][0];
			top[2][0] = tempCorner;
			
			char tempEdge = top[0][1];
			top[0][1] = top[1][2];
			top[1][2] = top[2][1];
			top[2][1] = top[1][0];
			top[1][0] = tempEdge;
		}
	}

	public void rotateLeft(int degree) { // degree is just 1, 2, 3
		char[] tempSide = new char[3];
		if(degree == 1) {
			tempSide[0] = top[0][0];
			tempSide[1] = top[1][0];
			tempSide[2] = top[2][0];
			
			top[0][0] = back[0][0];
			top[1][0] = back[1][0];
			top[2][0] = back[2][0];
			
			back[0][0] = bottom[0][0];
			back[1][0] = bottom[1][0];
			back[2][0] = bottom[2][0];
			
			bottom[0][0] = front[0][0];
			bottom[1][0] = front[1][0];
			bottom[2][0] = front[2][0];
			
			front[0][0] = tempSide[0];
			front[1][0] = tempSide[1];
			front[2][0] = tempSide[2];
			
			char tempCorner = left[0][0];
			left[0][0] = left[2][0];
			left[2][0] = left[2][2];
			left[2][2] = left[0][2];
			left[0][2] = tempCorner;
			
			char tempEdge = left[0][1];
			left[0][1] = left[1][0];
			left[1][0] = left[2][1];
			left[2][1] = left[1][2];
			left[1][2] = tempEdge;
		}
		if(degree == 2) {
			tempSide[0] = top[0][0];
			tempSide[1] = top[1][0];
			tempSide[2] = top[2][0];
			
			top[0][0] = bottom[0][0];
			top[1][0] = bottom[1][0];
			top[2][0] = bottom[2][0];
			
			bottom[0][0] = tempSide[0];
			bottom[1][0] = tempSide[1];
			bottom[2][0] = tempSide[2];
			
			tempSide[0] = back[0][0];
			tempSide[1] = back[1][0];
			tempSide[2] = back[2][0];
			
			back[0][0] = front[0][0];
			back[1][0] = front[1][0];
			back[2][0] = front[2][0];
			
			front[0][0] = tempSide[0];
			front[1][0] = tempSide[1];
			front[2][0] = tempSide[2];
			
			char tempCorner = left[0][0];
			left[0][0] = left[2][2];
			left[2][2] = tempCorner;
			
			tempCorner = left[0][2];
			left[0][2] = left[2][0];
			left[2][0] = tempCorner;
			
			char tempEdge = left[0][1];
			left[0][1] = left[2][1];
			left[2][1] = tempEdge;
			
			tempEdge = left[1][0];
			left[1][0] = left[1][2];
			left[1][2] = tempEdge;
		}
		if(degree == 3) {
			tempSide[0] = top[0][0];
			tempSide[1] = top[1][0];
			tempSide[2] = top[2][0];
			
			top[0][0] = front[0][0];
			top[1][0] = front[1][0];
			top[2][0] = front[2][0];
			
			front[0][0] = bottom[0][0];
			front[1][0] = bottom[1][0];
			front[2][0] = bottom[2][0];
			
			bottom[0][0] = back[0][0];
			bottom[1][0] = back[1][0];
			bottom[2][0] = back[2][0];
			
			back[0][0] = tempSide[0];
			back[1][0] = tempSide[1];
			back[2][0] = tempSide[2];
			
			char tempCorner = left[0][0];
			left[0][0] = left[0][2];
			left[0][2] = left[2][2];
			left[2][2] = left[2][0];
			left[2][0] = tempCorner;
			
			char tempEdge = left[0][1];
			left[0][1] = left[1][2];
			left[1][2] = left[2][1];
			left[2][1] = left[1][0];
			left[1][0] = tempEdge;
		}
	}

	public void rotateRight(int degree) { // degree is just 1, 2, 3
		char[] tempSide = new char[3];
		if(degree == 1) {
			tempSide[0] = top[2][2];
			tempSide[1] = top[1][2];
			tempSide[2] = top[0][2];
			
			top[2][2] = front[2][2];
			top[1][2] = front[1][2];
			top[0][2] = front[0][2];
			
			front[2][2] = bottom[2][2];
			front[1][2] = bottom[1][2];
			front[0][2] = bottom[0][2];
			
			bottom[2][2] = back[2][2];
			bottom[1][2] = back[1][2];
			bottom[0][2] = back[0][2];
			
			back[2][2] = tempSide[0];
			back[1][2] = tempSide[1];
			back[0][2] = tempSide[2];
			
			char tempCorner = right[0][0];
			right[0][0] = right[2][0];
			right[2][0] = right[2][2];
			right[2][2] = right[0][2];
			right[0][2] = tempCorner;
			
			char tempEdge = right[0][1];
			right[0][1] = right[1][0];
			right[1][0] = right[2][1];
			right[2][1] = right[1][2];
			right[1][2] = tempEdge;
		}
		if(degree == 2) {
			tempSide[0] = top[2][2];
			tempSide[1] = top[1][2];
			tempSide[2] = top[0][2];
			
			top[2][2] = bottom[2][2];
			top[1][2] = bottom[1][2];
			top[0][2] = bottom[0][2];
			
			bottom[2][2] = tempSide[0];
			bottom[1][2] = tempSide[1];
			bottom[0][2] = tempSide[2];
			
			tempSide[0] = back[2][2];
			tempSide[1] = back[1][2];
			tempSide[2] = back[0][2];
			
			back[2][2] = front[2][2];
			back[1][2] = front[1][2];
			back[0][2] = front[0][2];
			
			front[2][2] = tempSide[0];
			front[1][2] = tempSide[1];
			front[0][2] = tempSide[2];
			
			char tempCorner = right[0][0];
			right[0][0] = right[2][2];
			right[2][2] = tempCorner;
			
			tempCorner = right[0][2];
			right[0][2] = right[2][0];
			right[2][0] = tempCorner;
			
			char tempEdge = right[0][1];
			right[0][1] = right[2][1];
			right[2][1] = tempEdge;
			
			tempEdge = right[1][0];
			right[1][0] = right[1][2];
			right[1][2] = tempEdge;
		}
		if(degree == 3) {
			tempSide[0] = top[2][2];
			tempSide[1] = top[1][2];
			tempSide[2] = top[0][2];
			
			top[2][2] = back[2][2];
			top[1][2] = back[1][2];
			top[0][2] = back[0][2];
			
			back[2][2] = bottom[2][2];
			back[1][2] = bottom[1][2];
			back[0][2] = bottom[0][2];
			
			bottom[2][2] = front[2][2];
			bottom[1][2] = front[1][2];
			bottom[0][2] = front[0][2];
			
			front[2][2] = tempSide[0];
			front[1][2] = tempSide[1];
			front[0][2] = tempSide[2];
			
			char tempCorner = right[0][0];
			right[0][0] = right[0][2];
			right[0][2] = right[2][2];
			right[2][2] = right[2][0];
			right[2][0] = tempCorner;
			
			char tempEdge = right[0][1];
			right[0][1] = right[1][2];
			right[1][2] = right[2][1];
			right[2][1] = right[1][0];
			right[1][0] = tempEdge;
		}
	}

	public void rotateBottom(int degree) { // degree is just 1, 2, 3
		char[] tempSide = new char[3];
		if(degree == 1) {
			tempSide[0] = front[2][0];
			tempSide[1] = front[2][1];
			tempSide[2] = front[2][2];
			
			front[2][0] = left[2][0];
			front[2][1] = left[2][1];
			front[2][2] = left[2][2];
			
			left[2][0] = back[0][2];
			left[2][1] = back[0][1];
			left[2][2] = back[0][0];
			
			back[0][2] = right[2][0];
			back[0][1] = right[2][1];
			back[0][0] = right[2][2];
			
			right[2][0] = tempSide[0];
			right[2][1] = tempSide[1];
			right[2][2] = tempSide[2];
			
			char tempCorner = bottom[0][0];
			bottom[0][0] = bottom[2][0];
			bottom[2][0] = bottom[2][2];
			bottom[2][2] = bottom[0][2];
			bottom[0][2] = tempCorner;
			
			char tempEdge = bottom[0][1];
			bottom[0][1] = bottom[1][0];
			bottom[1][0] = bottom[2][1];
			bottom[2][1] = bottom[1][2];
			bottom[1][2] = tempEdge;
		}
		if(degree == 2) {
			tempSide[0] = front[2][0];
			tempSide[1] = front[2][1];
			tempSide[2] = front[2][2];
			
			front[2][0] = back[0][2];
			front[2][1] = back[0][1];
			front[2][2] = back[0][0];
			
			back[0][2] = tempSide[0];
			back[0][1] = tempSide[1];
			back[0][0] = tempSide[2];
			
			tempSide[0] = left[2][0];
			tempSide[1] = left[2][1];
			tempSide[2] = left[2][2];
			
			left[2][0] = right[2][0];
			left[2][1] = right[2][1];
			left[2][2] = right[2][2];
			
			right[2][0] = tempSide[0];
			right[2][1] = tempSide[1];
			right[2][2] = tempSide[2];
			
			char tempCorner = bottom[0][0];
			bottom[0][0] = bottom[2][2];
			bottom[2][2] = tempCorner;
			
			tempCorner = bottom[0][2];
			bottom[0][2] = bottom[2][0];
			bottom[2][0] = tempCorner;
			
			char tempEdge = bottom[0][1];
			bottom[0][1] = bottom[2][1];
			bottom[2][1] = tempEdge;
			
			tempEdge = bottom[1][0];
			bottom[1][0] = bottom[1][2];
			bottom[1][2] = tempEdge;
		}
		if(degree == 3) {
			tempSide[0] = front[2][0];
			tempSide[1] = front[2][1];
			tempSide[2] = front[2][2];
			
			front[2][0] = right[2][0];
			front[2][1] = right[2][1];
			front[2][2] = right[2][2];
			
			right[2][0] = back[0][2];
			right[2][1] = back[0][1];
			right[2][2] = back[0][0];
			
			back[0][2] = left[2][0];
			back[0][1] = left[2][1];
			back[0][0] = left[2][2];
			
			left[2][0] = tempSide[0];
			left[2][1] = tempSide[1];
			left[2][2] = tempSide[2];
			
			char tempCorner = bottom[0][0];
			bottom[0][0] = bottom[0][2];
			bottom[0][2] = bottom[2][2];
			bottom[2][2] = bottom[2][0];
			bottom[2][0] = tempCorner;
			
			char tempEdge = bottom[0][1];
			bottom[0][1] = bottom[1][2];
			bottom[1][2] = bottom[2][1];
			bottom[2][1] = bottom[1][0];
			bottom[1][0] = tempEdge;
		}
	}
	
	public void rotateBack(int degree) { // degree is just 1, 2, 3
		char[] tempSide = new char[3];
		if(degree == 1) {
			tempSide[0] = bottom[2][0];
			tempSide[1] = bottom[2][1];
			tempSide[2] = bottom[2][2];
			
			bottom[2][0] = left[0][0];
			bottom[2][1] = left[1][0];
			bottom[2][2] = left[2][0];
			
			left[0][0] = top[0][2];
			left[1][0] = top[0][1];
			left[2][0] = top[0][0];
			
			top[0][2] = right[2][2];
			top[0][1] = right[1][2];
			top[0][0] = right[0][2];
			
			right[2][2] = tempSide[0];
			right[1][2] = tempSide[1];
			right[0][2] = tempSide[2];
			
			char tempCorner = back[0][0];
			back[0][0] = back[2][0];
			back[2][0] = back[2][2];
			back[2][2] = back[0][2];
			back[0][2] = tempCorner;
			
			char tempEdge = back[0][1];
			back[0][1] = back[1][0];
			back[1][0] = back[2][1];
			back[2][1] = back[1][2];
			back[1][2] = tempEdge;
		}
		if(degree == 2) {
			tempSide[0] = bottom[2][0];
			tempSide[1] = bottom[2][1];
			tempSide[2] = bottom[2][2];
			
			bottom[2][0] = top[0][2];
			bottom[2][1] = top[0][1];
			bottom[2][2] = top[0][0];
			
			top[0][2] = tempSide[0];
			top[0][1] = tempSide[1];
			top[0][0] = tempSide[2];
			
			tempSide[0] = left[2][0];
			tempSide[1] = left[1][0];
			tempSide[2] = left[0][0];
			
			left[2][0] = right[0][2];
			left[1][0] = right[1][2];
			left[0][0] = right[2][2];
			
			right[0][2] = tempSide[0];
			right[1][2] = tempSide[1];
			right[2][2] = tempSide[2];
			
			char tempCorner = back[0][0];
			back[0][0] = back[2][2];
			back[2][2] = tempCorner;
			
			tempCorner = back[0][2];
			back[0][2] = back[2][0];
			back[2][0] = tempCorner;
			
			char tempEdge = back[0][1];
			back[0][1] = back[2][1];
			back[2][1] = tempEdge;
			
			tempEdge = back[1][0];
			back[1][0] = back[1][2];
			back[1][2] = tempEdge;
		}
		if(degree == 3) {
			tempSide[0] = bottom[2][0];
			tempSide[1] = bottom[2][1];
			tempSide[2] = bottom[2][2];
			
			bottom[2][0] = right[2][2];
			bottom[2][1] = right[1][2];
			bottom[2][2] = right[0][2];
			
			right[2][2] = top[0][2];
			right[1][2] = top[0][1];
			right[0][2] = top[0][0];
			
			top[0][2] = left[0][0];
			top[0][1] = left[1][0];
			top[0][0] = left[2][0];
			
			left[0][0] = tempSide[0];
			left[1][0] = tempSide[1];
			left[2][0] = tempSide[2];
			
			char tempCorner = back[0][0];
			back[0][0] = back[0][2];
			back[0][2] = back[2][2];
			back[2][2] = back[2][0];
			back[2][0] = tempCorner;
			
			char tempEdge = back[0][1];
			back[0][1] = back[1][2];
			back[1][2] = back[2][1];
			back[2][1] = back[1][0];
			back[1][0] = tempEdge;
		}
	}	
}
