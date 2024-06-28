package aplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chass.ChassException;
import chass.ChassMatch;
import chass.ChassPiece;
import chass.ChassPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ChassMatch chessMatch = new ChassMatch();
		List<ChassPiece> captured = new ArrayList<>();

		
		while (true) {
			try {
				UI.clearScrean();
				UI.printMach(chessMatch, captured);
				System.out.println();
				System.out.println("Source: ");
				ChassPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScrean();
				UI.printBoard(chessMatch.getPices(), possibleMoves);
				
				
				System.out.println();
				System.out.println("Target: ");
				ChassPosition target = UI.readChessPosition(sc);
				
				ChassPiece captuedPiece = chessMatch.performChessMove(source, target);

				if(captuedPiece != null) {
					captured.add(captuedPiece);
				}
			}
			catch (ChassException e){
				System.out.println(e.getMessage());
				sc.hasNextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}

	}

}
