package ch03.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import ch03.logic.OnitamaGame;
import ch03.logic.Piece;

public class PiecesDragAndDropListener implements MouseListener, MouseMotionListener {

	private List<GuiPiece> guiPieces;
	private OnitamaGui onitamaGui;
	
	//private GuiPiece dragPiece;
	private int dragOffsetX;
	private int dragOffsetY;
	

	public PiecesDragAndDropListener(List<GuiPiece> guiPieces, OnitamaGui onitamaGui) {
		this.guiPieces = guiPieces;
		this.onitamaGui = onitamaGui;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent evt) {
		int x = evt.getPoint().x;
		int y = evt.getPoint().y;
		
		// find out which piece to move.
		// we check the list from top to buttom
		// (therefore we itereate in reverse order)
		//
		for (int i = this.guiPieces.size()-1; i >= 0; i--) {
			GuiPiece guiPiece = this.guiPieces.get(i);
			if (guiPiece.isCaptured()) continue;

			if(mouseOverPiece(guiPiece,x,y)){
				
				if( (	this.onitamaGui.getGameState() == OnitamaGame.GAME_STATE_WHITE
						&& guiPiece.getColor() == Piece.COLOR_WHITE
					) ||
					(	this.onitamaGui.getGameState() == OnitamaGame.GAME_STATE_BLACK
							&& guiPiece.getColor() == Piece.COLOR_BLACK
						)
					){
					// calculate offset, because we do not want the drag piece
					// to jump with it's upper left corner to the current mouse
					// position
					//
					this.dragOffsetX = x - guiPiece.getX();
					this.dragOffsetY = y - guiPiece.getY();
					this.onitamaGui.setDragPiece(guiPiece);
					this.onitamaGui.repaint();
					break;
				}
			}
		}
		
		// move drag piece to the top of the list
		if(this.onitamaGui.getDragPiece() != null){
			this.guiPieces.remove( this.onitamaGui.getDragPiece() );
			this.guiPieces.add(this.onitamaGui.getDragPiece());
		}
	}

	/**
	 * check whether the mouse is currently over this piece
	 */
	private boolean mouseOverPiece(GuiPiece guiPiece, int x, int y) {

		return guiPiece.getX() <= x 
			&& guiPiece.getX()+guiPiece.getWidth() >= x
			&& guiPiece.getY() <= y
			&& guiPiece.getY()+guiPiece.getHeight() >= y;
	}

	@Override
	public void mouseReleased(MouseEvent evt) {
		if( this.onitamaGui.getDragPiece() != null){
			int x = evt.getPoint().x - this.dragOffsetX;
			int y = evt.getPoint().y - this.dragOffsetY;
			
			// set game piece to the new location if possible
			//
			onitamaGui.setNewPieceLocation(this.onitamaGui.getDragPiece(), x, y);
			this.onitamaGui.repaint();
			this.onitamaGui.setDragPiece(null);
		}
	}

	@Override
	public void mouseDragged(MouseEvent evt) {
		if(this.onitamaGui.getDragPiece() != null){
			
			int x = evt.getPoint().x - this.dragOffsetX;
			int y = evt.getPoint().y - this.dragOffsetY;
			
			System.out.println(
					"row:"+ OnitamaGui.convertYToRow(y)
					+" column:"+ OnitamaGui.convertXToColumn(x));

			GuiPiece dragPiece = this.onitamaGui.getDragPiece();
			dragPiece.setX(x);
			dragPiece.setY(y);
			
			this.onitamaGui.repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}

}
