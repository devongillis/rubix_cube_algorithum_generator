package rubix_cube_algorithum_generator;

public class Main {
	
	public static RubixCube cube;

	public static void main(String[] args) {
		// the rubix cube will be stored as six nested arrays
		// of chars 6 x 3x3 and each function will properly
		// swap their values to simulate a turn
		// a master checker will use set conditions to see
		// if the puzzle is in a desired state
		// these conditions can range from color specifics
		// or which faces are allowed to be turned
		// the system will check all possibilities of turning
		// and return the instructions to achieve each desired
		// result, also set a maximum move limit and allow only
		// turns of 1,2,3
		cube = new RubixCube();
		char[][] front = new char[3][3];
		char[][] back = new char[3][3];
		char[][] left = new char[3][3];
		char[][] right = new char[3][3];
		char[][] top = new char[3][3];
		char[][] bottom = new char[3][3];
		
		front[0][0] = 'w'; front[0][1] = 'o'; front[0][2] = 'w';
		front[1][0] = 'w'; front[1][1] = 'w'; front[1][2] = 'w';
		front[2][0] = 'w'; front[2][1] = 'w'; front[2][2] = 'w';
		
		back[0][0] = 'y'; back[0][1] = 'y'; back[0][2] = 'y';
		back[1][0] = 'y'; back[1][1] = 'y'; back[1][2] = 'y';
		back[2][0] = 'y'; back[2][1] = 'r'; back[2][2] = 'y';
		
		left[0][0] = 'o'; left[0][1] = 'w'; left[0][2] = 'o';
		left[1][0] = 'o'; left[1][1] = 'o'; left[1][2] = 'o';
		left[2][0] = 'o'; left[2][1] = 'o'; left[2][2] = 'o';
		
		right[0][0] = 'r'; right[0][1] = 'y'; right[0][2] = 'r';
		right[1][0] = 'r'; right[1][1] = 'r'; right[1][2] = 'r';
		right[2][0] = 'r'; right[2][1] = 'r'; right[2][2] = 'r';
		
		top[0][0] = 'b'; top[0][1] = 'b'; top[0][2] = 'b';
		top[1][0] = 'b'; top[1][1] = 'b'; top[1][2] = 'b';
		top[2][0] = 'b'; top[2][1] = 'b'; top[2][2] = 'b';
		
		bottom[0][0] = 'g'; bottom[0][1] = 'g'; bottom[0][2] = 'g';
		bottom[1][0] = 'g'; bottom[1][1] = 'g'; bottom[1][2] = 'g';
		bottom[2][0] = 'g'; bottom[2][1] = 'g'; bottom[2][2] = 'g';
		
		
		cube.setConditions(front, back, left, right, top, bottom);
		
		
		
		
		//cube.rotateTop(1);
		//mixup();
		int max = 20;
		long time = System.nanoTime();
		for(int i = 1; i <= max; i++) {
			int[][] number = new int[i][2];
			solve(number.length, number, -1);
		}
		long duration = System.nanoTime() - time;
		float seconds = (float) (duration/1000000000);
		System.out.println(seconds + " seconds " + duration);
		
		
		
		
		
		
		
		
										printLayout(cube.top, true);
		printLayer(cube.left[0], false);printLayer(cube.front[0], false);printLayer(cube.right[0], false);System.out.println();
		printLayer(cube.left[1], false);printLayer(cube.front[1], false);printLayer(cube.right[1], false);System.out.println();
		printLayer(cube.left[2], false);printLayer(cube.front[2], false);printLayer(cube.right[2], false);System.out.println();
										printLayout(bottom, true);
										printLayout(back, true);
	}
	
	public static void printLayout(char[][] face, boolean space) {
		for(int i = 0; i < 3; i++) {
			if(space) {
				System.out.print("   ");
			}
			for(int j = 0; j < 3; j++) {
				System.out.print(face[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void printLayer(char[] layer, boolean space) {
		for(int i = 0; i < 3; i++) {
			System.out.print(layer[i]);
		}
	}
	
	public static void mixup() {
		
	}
	
	public static void flipTwoEdges() {
		cube.rotateLeft(1);
		cube.rotateRight(3);
		
		cube.rotateFront(1);
		
		cube.rotateLeft(1);
		cube.rotateRight(3);
		
		cube.rotateBottom(1);
		
		cube.rotateLeft(1);
		cube.rotateRight(3);
		
		cube.rotateBack(2);
		
		cube.rotateLeft(3);
		cube.rotateRight(1);
		
		cube.rotateBottom(1);
		
		cube.rotateLeft(3);
		cube.rotateRight(1);
		
		cube.rotateFront(1);
		
		cube.rotateLeft(3);
		cube.rotateRight(1);
		
		cube.rotateTop(2);
	}

	public static void solve(int digitsLeft, int[][] number, int previousFace) {
		digitsLeft -= 1;
		for(int face = 2; face < 4; face++) {
			//if(face == 3 || face == 2) {
				for(int angle = 1; angle <= 3; angle++) {
					if(face != previousFace) {
						number[number.length - 1 - digitsLeft][0] = face;
						number[number.length - 1 - digitsLeft][1] = angle;
						if(digitsLeft != 0) {
							solve(digitsLeft, number, face);
						}
						else {
							// found our final number now use it to turn puzzle
							for(int i = 0; i < number.length; i++) {
								cube.rotateFace(number[i][0], number[i][1]);
							}
							// now check if the sequence of turns is a solution
							if(checkIfSolved() /*checkIfConditionsMet()*/ /*checkConditions()*/) {
								for(int i = 0; i < number.length; i++) {
									System.out.print(number[i][0] + "" + number[i][1] + " ");
								}
								System.out.println();
							}
							// undo the number
							for(int i = number.length - 1; i >= 0; i--) {
								cube.rotateFace(number[i][0], 4 - number[i][1]);
							}
						}
					}
				}
			//}
		}
	}
	
	public static boolean checkIfSolved() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(cube.front[i][j] != 'w') {
					return false;
				}
				if(cube.left[i][j] != 'o') {
					return false;
				}
				if(cube.right[i][j] != 'r') {
					return false;
				}
				if(cube.top[i][j] != 'b') {
					return false;
				}
				if(cube.bottom[i][j] != 'g') {
					return false;
				}
				if(cube.back[i][j] != 'y') {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkConditions() {
		
		if(cube.left[2][2] != 'o') {
			return false;
		}
		if(cube.left[1][2] != 'o') {
			return false;
		}
		
		for(int i = 1; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(cube.front[i][j] != 'w') {
					return false;
				}
			}
		}
		for(int i = 1; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(cube.right[i][j] != 'r') {
					return false;
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			if(cube.bottom[0][i] != 'g') {
				return false;
			}
		}
		if(cube.bottom[1][2] != 'g') {
			return false;
		}
		if(cube.bottom[2][2] != 'g') {
			return false;
		}
		
		if(cube.back[0][2] != 'y') {
			return false;
		}
		if(cube.back[1][2] != 'y') {
			return false;
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(cube.top[j][i] != 'b') {
					return false;
				}
			}
		}
		
		if(cube.left[0][0] != cube.left[0][2]) {
			return false;
		}
		if(cube.right[0][0] != cube.right[0][2]) {
			return false;
		}
		
		return true;
	}
	
	public static boolean checkIfConditionsMet() {
		// in this function we don't care about the edge pieces only if the corners are correct
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(cube.bottom[i][j] != 'g') {
					return false;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 1; j < 3; j++) {
				if(cube.left[j][i] != 'o') {
					return false;
				}
				if(cube.front[j][i] != 'w') {
					return false;
				}
				if(cube.right[j][i] != 'r') {
					return false;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 2; j++) {
				if(cube.back[j][i] != 'y') {
					return false;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(cube.top[j][i] != 'b') {
					return false;
				}
			}
		}
		/*
		if(cube.left[0][0] != 'o') {
			return false;
		}
		if(cube.left[0][2] != 'o') {
			return false;
		}
		if(cube.front[0][0] != 'w') {
			return false;
		}
		if(cube.front[0][2] != 'w') {
			return false;
		}
		if(cube.right[0][0] != 'r') {
			return false;
		}
		if(cube.right[0][2] != 'r') {
			return false;
		}
		if(cube.back[2][0] != 'y') {
			return false;
		}
		if(cube.back[2][2] != 'y') {
			return false;
		}
		*/
		
		return true;
	}
}
