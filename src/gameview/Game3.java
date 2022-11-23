package gameview;

import java.util.ArrayList;
import java.util.Scanner;

public class Game3 {
	ArrayList<String> list = new ArrayList<String>();
	public static int min;
	public static String pathMin;
	static public String minPath = "";
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		new Game3().getData();

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
		int monsterColumn = scanner.nextInt();
		matrix[goldRow - 1][goldColumn - 1] = 3;
		String path = " ";
		int monstMin = method(matrix, monsterRow - 1, monsterColumn - 1, 0, goldRow - 1, goldColumn - 1, list);
		list.clear();
		list.add((adventureRow) + "," + (adventureColumn));
		int admin = method(matrix, adventureRow - 1, adventureColumn - 1, 0, goldRow - 1, goldColumn - 1, list);
		if (monstMin < admin) {
			System.out.println("Not Posible To Way");
		} else {
			System.out.println(list);
			System.out.println(admin);
		}

	}

	private int method(int[][] matrix, int startRow, int startColumn, int count, int endRow, int endColumn,
			ArrayList<String> list) {
		if (startColumn > endColumn)    {
			startColumn--;

			count++;
			list.add((startRow + 1) + "," + (startColumn + 1));
		} else if (startColumn < endColumn) {
			startColumn++;
			count++;
			list.add((startRow + 1) + "," + (startColumn + 1));
		} else if (startRow > endRow) {
			startRow--;
			count++;
			list.add((startRow + 1) + "," + (startColumn + 1));
		} else if (startRow < endRow) {
			startRow++;

			count++;
			list.add((startRow + 1) + "," + (startColumn + 1));
		}
		if (startRow == endRow) {
			if (matrix[startRow][startColumn] == 3) {
				return count;
			}
		}
		return method(matrix, startRow, startColumn, count, endRow, endColumn, list);
	}
}
