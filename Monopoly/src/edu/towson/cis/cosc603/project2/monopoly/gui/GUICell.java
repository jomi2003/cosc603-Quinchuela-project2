package edu.towson.cis.cosc603.project2.monopoly.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import edu.towson.cis.cosc603.project2.monopoly.*;

public class GUICell extends JPanel {

	
	private GUICellProduct gUICellProduct = new GUICellProduct();
	private static final long serialVersionUID = 1L;
	private IOwnable cell;
	private JLabel lblInfo;
	public GUICell(IOwnable cell) {
        this.cell = cell;
        setLayout(new OverlayLayout(this));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        JPanel pnlPlayer = new JPanel();
        pnlPlayer.setLayout(new GridLayout(2, 4));
        pnlPlayer.setOpaque(false);
        gUICellProduct.createPlayerLabels(pnlPlayer);
        add(pnlPlayer);
        setPreferredSize(new Dimension(100,100));
        addCellInfo();
        this.doLayout();
	}
	
	private void addCellInfo() {
        lblInfo = new JLabel();
		displayInfo();
        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new GridLayout(1, 1));
        pnlInfo.add(lblInfo);
        add(pnlInfo);
    }
	
	public void addPlayer(int index) {
		gUICellProduct.addPlayer(index);
	}

    public void displayInfo() {
		lblInfo.setText(InfoFormatter.cellInfo(cell));
        this.invalidate();
		this.repaint();
	}

	public IOwnable getCell() {
		return cell;
	}
	
	public void removePlayer(int index) {
		gUICellProduct.removePlayer(index, this);
	}
}
