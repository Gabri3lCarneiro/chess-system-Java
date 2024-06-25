package aplication;

import java.util.Scanner;

import chass.ChassMatch;
import chass.ChassPiece;
import chass.ChassPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ChassMatch chessMatch = new ChassMatch();

		while (true) {
			UI.printBoard(chessMatch.getPices());
			System.out.println();
			System.out.println("Source: ");
			ChassPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.println("Target: ");
			ChassPosition target = UI.readChessPosition(sc);
			
			ChassPiece captuedPiece = chessMatch.performChessMove(source, target);

			
		}

	}

}
