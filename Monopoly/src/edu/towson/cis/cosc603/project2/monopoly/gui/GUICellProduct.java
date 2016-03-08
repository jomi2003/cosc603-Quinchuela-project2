package edu.towson.cis.cosc603.project2.monopoly.gui;


import javax.swing.JLabel;
import edu.towson.cis.cosc603.project2.monopoly.GameMaster;
import javax.swing.JPanel;
import java.awt.Color;
import edu.towson.cis.cosc603.project2.monopoly.Player;
import java.io.Serializable;

public class GUICellProduct implements Serializable {
	private JLabel[] lblPlayers = new JLabel[GameMaster.MAX_PLAYER];

	public void createPlayerLabels(JPanel pnlPlayer) {
		for (int i = 0; i < GameMaster.MAX_PLAYER; i++) {
			lblPlayers[i] = new JLabel();
			lblPlayers[i].setBackground(Color.GREEN);
			pnlPlayer.add(lblPlayers[i]);
		}
	}

	public void removePlayer(int index, GUICell gUICell) {
		lblPlayers[index].setText("");
		lblPlayers[index].setOpaque(false);
		gUICell.repaint();
	}

	public void addPlayer(int index) {
		Player player = GameMaster.instance().getPlayer(index);
		lblPlayers[index].setText(player.getName().substring(0, 1));
		lblPlayers[index].setOpaque(true);
	}
}