package gameview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game5 {

	ArrayList<String> list = new ArrayList<String>();
	public static int min;
	public static String pathMin;
	static public String minPath = "";
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		new Game5().getData();

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

		matrix[goldRow - 1][goldColumn - 1] = 3;
		System.out.println("Enter the Number Of Pits");
		int pits = scanner.nextInt();
		for (int i = 0; i < pits; i++) {
			System.out.println("Enterr the Row Of Pit");
			int pitRow = scanner.nextInt();
			System.out.println("Enter the Column Of the Pit");
			int pitColumn = scanner.nextInt();
			matrix[pitRow - 1][pitColumn - 1] = 4;
		}

		System.out.println(Arrays.deepToString(matrix));

		list.add((adventureRow) + "," + (adventureColumn));
		int admin = method(matrix, adventureRow - 1, adventureColumn - 1, 0, goldRow - 1, goldColumn - 1, list, 3);
		System.out.println("Paths  : " + list);
		System.out.println("Minimum Posible Way :  " + admin);
	}

	private int method(int[][] matrix, int startRow, int startColumn, int count, int endRow, int endColumn,
			ArrayList<String> list, int torget) {
		if ((startColumn > endColumn) && ((matrix[startRow][startColumn - 1] == 0)||matrix[startRow][startColumn-1] == torget)) {
			matrix[startRow][startColumn] = 4;
			startColumn--;
			count++;
			list.add((startRow + 1) + "," + (startColumn + 1));
		} else if ((startColumn < endColumn) && ((matrix[startRow][startColumn + 1] == 0)||matrix[startRow][startColumn+1] == torget)) {
			matrix[startRow][startColumn] = 4;

			startColumn++;
			count++;
			list.add((startRow + 1) + "," + (startColumn + 1));
		} else if ((startRow > endRow) && ((matrix[startRow - 1][startColumn] == 0)||matrix[startRow-1][startColumn] == torget)) {
			matrix[startRow][startColumn] = 4;
			startRow--;
			count++;
			list.add((startRow + 1) + "," + (startColumn + 1));
		} else if ((startRow < endRow) && ((matrix[startRow + 1][startColumn] == 0)||matrix[startRow+1][startColumn] == torget)) {
			matrix[startRow][startColumn] = 4;
			startRow++;
			count++;
			list.add((startRow + 1) + "," + (startColumn + 1));
		}

		else if ((startColumn <= endColumn) && (matrix[startRow][startColumn + 1] == 4)) {
			if (startRow > 0 && (matrix[startRow - 1][startColumn] == 0)) {
				matrix[startRow][startColumn] = 4;
				startRow--;
				count++;
				list.add((startRow + 1) + "," + (startColumn + 1));
			} else if (startColumn > 0 && (matrix[startRow][startColumn - 1] == 0)) {
				matrix[startRow][startColumn] = 4;
				startColumn--;
				count++;
				list.add((startRow + 1) + "," + (startColumn + 1));
			} else if (startColumn < matrix[0].length && (matrix[startRow][startColumn + 1] == 0)) {
				matrix[startRow][startColumn] = 4;
				startColumn++;
				count++;
				list.add((startRow + 1) + "," + (startColumn + 1));
			} else if (startRow < matrix.length - 1 && (matrix[startRow + 1][startColumn] == 0)) {
				matrix[startRow][startColumn] = 4;
				startRow++;
				count++;
				list.add((startRow + 1) + "," + (startColumn + 1));
			} else {
				System.out.println("Not Posible");
				return 0;
			}
		} else if ((startColumn >= endColumn) && (matrix[startRow][startColumn - 1] == 4)) {
			if (startRow < matrix.length - 1 && (matrix[startRow + 1][startColumn] == 0)) {
				matrix[startRow][startColumn] = 4;
				startRow++;
				count++;
				list.add((startRow + 1) + "," + (startColumn + 1));
			} else if (startColumn < matrix[0].length - 1 && (matrix[startRow][startColumn + 1] == 0)) {
				matrix[startRow][startColumn] = 4;
				startColumn++;
				count++;
				list.add((startRow + 1) + "," + (startColumn + 1));
			} else if (startRow > 0 && (matrix[startRow - 1][startColumn] == 0)) {
				matrix[startRow][startColumn] = 4;
				startRow--;
				count++;
				list.add((startRow + 1) + "," + (startColumn + 1));
			} else if (startColumn > 0 && (matrix[startRow][startColumn - 1] == 0)) {
				matrix[startRow][startColumn] = 4;
				startColumn--;
				count++;
				list.add((startRow + 1) + "," + (startColumn + 1));
			} else {
				System.out.println("Not Posible");
				return 0;
			}

		}

		else if (matrix[startRow][startColumn] == torget) {
			return count;

		} else {

			list.add((endRow + 1) + "," + (endColumn + 1));
			count++;
			return count;
		}
		if (matrix[startRow][startColumn] == torget) {
			return count;

		}
		return method(matrix, startRow, startColumn, count, endRow, endColumn, list, torget);
	}

}
