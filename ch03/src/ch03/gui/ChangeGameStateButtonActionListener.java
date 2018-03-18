package ch03.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChangeGameStateButtonActionListener implements ActionListener {

	private OnitamaGui onitamaGui;

	public ChangeGameStateButtonActionListener(OnitamaGui onitamaGui) {
		this.onitamaGui = onitamaGui;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// change game state
		this.onitamaGui.changeGameState();
	}
}
