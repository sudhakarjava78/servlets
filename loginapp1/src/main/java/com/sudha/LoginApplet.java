package com.sudha;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class LoginApplet extends Applet implements ActionListener {

	Label l1, l2;
	TextField tf1, tf2;
	Button b;
	String res = "";

	public void init() {
		this.setBackground(Color.pink);
		this.setLayout(new FlowLayout());
		l1 = new Label("User Name");
		l2 = new Label("Password");
		tf1 = new TextField(20);
		tf2 = new TextField(20);
		tf2.setEchoChar('*');
		b = new Button("Login");
		b.addActionListener(this);
		this.add(l1);
		this.add(tf1);
		this.add(l2);
		this.add(tf2);
		this.add(b);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			URL url = new URL(
					"http://localhost:8080/loginapp1/login?uname=" + tf1.getText() + "&upwd=" + tf2.getText());
			URLConnection uc = url.openConnection();
			uc.setDoInput(true);
			InputStream is = uc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			res = br.readLine();
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		Font f = new Font("arial", Font.BOLD, 30);
		g.setFont(f);
		g.drawString("Status :" + res, 50, 250);
	}

}
