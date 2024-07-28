package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		
		while (!chessMatch.getChackMate()) {
			try {
				UI.clearScrean();
				UI.printMach(chessMatch, captured);
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScrean();
				UI.printBoard(chessMatch.getPices(), possibleMoves);
				
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece captuedPiece = chessMatch.performChessMove(source, target);

				if(captuedPiece != null) {
					captured.add(captuedPiece);
				}
				if(chessMatch.getPromoted() != null) {
					System.out.println("Enter pice for promotion (B/N/R/Q): ");
					String type = sc.nextLine().toUpperCase();
					while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.println("Invalid value! Enter pice for promotion (B/N/R/Q): ");
						
						 type = sc.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}
			}
			catch (ChessException e){
				System.out.println(e.getMessage());
				sc.hasNextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}
		UI.clearScrean();
		UI.printMach(chessMatch, captured);

	}

}
