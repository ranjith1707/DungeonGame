package gameview;

import java.util.ArrayList;
import java.util.Scanner;

import Controler.PathTracking;

public class Game1 {
	public static int min;
	public static String pathMin;
	static public String minPath = "";
	private Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		new Game1().getData();

	}
	private void getData() {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("Enetr the Number Of Row For Dungeon ");
		int row = scanner.nextInt();
		System.out.println("Enter the Number Of Column in DUndeon");
		int column = scanner.nextInt();
		int[][] matrix = new int[row][column];
		System.out.println("Enter the Gold row ");
		int goldRow = scanner.nextInt();
		System.out.println("Enter the Column Of Gold");
		int goldColumn = scanner.nextInt();
		System.out.println("Enter the Row Of Adventure");
		int adventureRow = scanner.nextInt();
		System.out.println("Enter The Column Of Adventure");
		int adventureColumn = scanner.nextInt();
		int min = row * column;
		System.out.println("Enter the Monster Row");
		int monsterRow = scanner.nextInt();
		System.out.println("Enter the monster Column");
		matrix[goldRow-1][goldColumn-1] = 3;
		String path = " ";
		min = method(matrix, adventureRow - 1, adventureColumn - 1, 0, goldRow-1, goldColumn-1);

		System.out.println(min);
	}

	private int method(int[][] matrix, int startRow, int startColumn, int count, int endRow, int endColumn) {
		if (startRow > endRow) {
			startRow--;
			count++;
		} else if (startRow < endRow) {
			startRow++;
			count++;
		}
		else if (startColumn > endColumn) {
			startColumn--;
			count++;
		} else if (startColumn < endColumn) {
			startColumn++;
			count++;
		}
		if (startRow == endRow) {
			if (matrix[startRow][startColumn] == 3) {

				return count;
			}
		}
		return method(matrix, startRow, startColumn, count, endRow, endColumn);
	}

}
