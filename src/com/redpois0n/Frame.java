package com.redpois0n;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtAPI;
	private JTextField txtUID;
	private JTextField txtURL;
	private JComboBox<String> cbAdvert;
	private JComboBox<String> cbDomain;
	private JTextPane txtShort;

	public Frame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				save();
			}
		});
		setTitle("Adfly");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/com/redpois0n/icons/icon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 342);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Util.openUrl("http://adf.ly");
				Util.openUrl("http://redpois0n.com");
			}
		});
		label.setIcon(new ImageIcon(Frame.class.getResource("/com/redpois0n/icons/logo.png")));
		
		JLabel lblApiKey = new JLabel("API Key:");
		
		txtAPI = new JTextField();
		txtAPI.setColumns(10);
		
		JLabel lblUid = new JLabel("UID:");
		
		txtUID = new JTextField();
		txtUID.setColumns(10);
		
		JLabel lblAdvert = new JLabel("Advert:");
		
		cbAdvert = new JComboBox<String>();
		cbAdvert.setModel(new DefaultComboBoxModel<String>(new String[] {"int", "banner"}));
		
		JLabel lblDomain = new JLabel("Domain:");
		
		cbDomain = new JComboBox<String>();
		cbDomain.setModel(new DefaultComboBoxModel<String>(new String[] {"adf.ly", "q.gs", "j.gs"}));
		
		JLabel lblUrl = new JLabel("URL:");
		
		txtURL = new JTextField();
		txtURL.setColumns(10);
		
		JLabel lblShortLink = new JLabel("Short link:");
		
		txtShort = new JTextPane();
		txtShort.setEditable(false);
		txtShort.setBorder(BorderFactory.createLineBorder(Color.gray.brighter()));
		txtShort.setText(" ");
		
		JButton btnPost = new JButton("Post");
		btnPost.setBackground(new Color(0, 153, 255));
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				post();
			}
		});
		
		JButton btnGetApiInfo = new JButton("Get API info");
		btnGetApiInfo.setBackground(new Color(0, 153, 255));
		btnGetApiInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Util.openUrl("http://adf.ly/tools.php?api");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnGetApiInfo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPost))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(59)
								.addComponent(label))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(10)
								.addComponent(lblApiKey)
								.addGap(18)
								.addComponent(txtAPI, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(15)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblAdvert)
									.addComponent(lblUid))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(cbAdvert, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtUID, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(14)
								.addComponent(lblDomain)
								.addGap(17)
								.addComponent(cbDomain, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(27)
								.addComponent(lblUrl)
								.addGap(20)
								.addComponent(txtURL, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(1)
								.addComponent(lblShortLink)
								.addGap(21)
								.addComponent(txtShort))))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblApiKey))
						.addComponent(txtAPI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUid))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbAdvert, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdvert))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(cbDomain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblDomain)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblUrl))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(txtURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblShortLink))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(txtShort, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPost)
						.addComponent(btnGetApiInfo))
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
		
		load();
	}
	
	public void load() {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("adfly.properties"));
			txtAPI.setText((String)prop.get("api"));
			txtUID.setText((String)prop.get("uid"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void save() {
		try {
			Properties prop = new Properties();
			prop.put("api", txtAPI.getText());
			prop.put("uid", txtUID.getText());
			
			prop.store(new FileOutputStream("adfly.properties"), "AdFly Desktop Properties");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void post() {
		try {
			String key = txtAPI.getText().trim();
			String uid = txtUID.getText().trim();
			String advert_type = cbAdvert.getSelectedItem().toString();
			String domain = cbDomain.getSelectedItem().toString();
			String url = txtURL.getText().trim();
			
			if (key.length() == 0 || uid.length() == 0 || url.length() == 0) {
				throw new Exception("Empty value");
			}
			
			txtShort.setText(API.get(key, uid, advert_type, domain, url));
		} catch (Exception ex) {
			ex.printStackTrace();
			txtShort.setText("ERROR: " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
		}
	}
}
