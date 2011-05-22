package com.wordpress.salaboy.smarttasks.ui;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jdesktop.application.Application;

import com.wordpress.salaboy.smarttasks.server.activiti.ActivitiHumanTaskManagement;
import com.wordpress.salaboy.smarttasks.server.jbpm5.JBPM5TaskManager;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ApplicationFrame extends javax.swing.JFrame {
	private JButton startJBPM5Process;
	private JButton startJBPM5ServerButton;
	private JButton ActivitiProcessImg;
	private JButton jbpm5;
	private JLabel statusLabel;
	private JButton stopActivitiServerButton;
	private JButton stopJBPM5ServerButton;
	private JButton startActivitiServerButton;
	private JButton startActivitiSampleButton;
	final JFrame theframe = this;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ApplicationFrame inst = new ApplicationFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ApplicationFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		this.setTitle("Sample Management Console");
		try {
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				stopActivitiServerButton = new JButton();
				stopActivitiServerButton.setText("stopActivitiServer");
				stopActivitiServerButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						stopActivitiServerButtonMouseClicked(evt);
					}
				});
				stopActivitiServerButton.setEnabled(false);
			}
			{
				stopJBPM5ServerButton = new JButton();
				stopJBPM5ServerButton.setText("stopJBPM5Server");
				stopJBPM5ServerButton.setEnabled(false);
				stopJBPM5ServerButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						stopJBPM5ServerButtonMouseClicked(evt);
						startJBPM5ServerButton.setEnabled(true);
						stopJBPM5ServerButton.setEnabled(false);
					}
				});
			}
			{
				startActivitiServerButton = new JButton();
				startActivitiServerButton.setText("StartActivitiServer");
				startActivitiServerButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						startActivitiServerButtonMouseClicked(evt);
					}
				});
			}
			{
				startJBPM5ServerButton = new JButton();
				startJBPM5ServerButton.setText("StartJBPM5Server");
				startJBPM5ServerButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						startJBPM5ServerButtonMouseClicked(evt);
						startJBPM5ServerButton.setEnabled(false);
						stopJBPM5ServerButton.setEnabled(true);
					}
				});
			}
			{
				statusLabel = new JLabel();
				statusLabel.setForeground(Color.RED);
			}
			{
				jbpm5 = new JButton();
				jbpm5.setText("JBPM5 Process Image");
				jbpm5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JDialog frame = new JDialog(theframe, "Image");
						Panel panel = new ShowImage("humanTask.png");
						frame.getContentPane().add(panel);
						frame.setSize(panel.getWidth(), panel.getHeight());
						frame.setVisible(true);
					}
				});

			}
			{
				ActivitiProcessImg = new JButton();
				ActivitiProcessImg.setText("ActivitiProcessImg");
				ActivitiProcessImg.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						ActivitiProcessImgMouseClicked(evt);
					}
				});
			}
			{
				startActivitiSampleButton = new JButton();
				startActivitiSampleButton.setText("StartActivitiSample");
				startActivitiSampleButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						startActivitiSampleButtonMouseClicked(evt);
					}
				});
			}
			{
				startJBPM5Process = new JButton();
				startJBPM5Process.setText("startJBPM5Process");
				startJBPM5Process.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						startJBPM5ProcessMouseClicked(evt);
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addGap(6)
				.addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(startActivitiServerButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				    .addComponent(startJBPM5ServerButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(stopActivitiServerButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				    .addComponent(stopJBPM5ServerButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGap(23)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(startActivitiSampleButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
				    .addComponent(startJBPM5Process, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(ActivitiProcessImg, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jbpm5, GroupLayout.Alignment.BASELINE, 0, 26, Short.MAX_VALUE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createParallelGroup()
				.addComponent(statusLabel, GroupLayout.Alignment.LEADING, 0, 523, Short.MAX_VALUE)
				.addGroup(thisLayout.createSequentialGroup()
				    .addPreferredGap(statusLabel, startJBPM5Process, LayoutStyle.ComponentPlacement.INDENT)
				    .addGroup(thisLayout.createParallelGroup()
				        .addComponent(startJBPM5Process, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
				        .addComponent(stopJBPM5ServerButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
				        .addComponent(startJBPM5ServerButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jbpm5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
				    .addGap(23)
				    .addGroup(thisLayout.createParallelGroup()
				        .addGroup(thisLayout.createSequentialGroup()
				            .addComponent(startActivitiSampleButton, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
				        .addGroup(thisLayout.createSequentialGroup()
				            .addComponent(stopActivitiServerButton, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
				        .addGroup(thisLayout.createSequentialGroup()
				            .addComponent(startActivitiServerButton, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
				        .addGroup(thisLayout.createSequentialGroup()
				            .addComponent(ActivitiProcessImg, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
				    .addContainerGap(17, Short.MAX_VALUE)));
			pack();
			this.setSize(533, 261);
			Application.getInstance().getContext().getResourceMap(getClass())
					.injectComponents(getContentPane());
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private JBPM5TaskManager taskServerDaemon;

	private void startJBPM5ServerButtonMouseClicked(MouseEvent evt) {
		System.out.println("startJBPM5ServerButton.mouseClicked, event=" + evt);
		try {
			taskServerDaemon = new JBPM5TaskManager();

			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					System.out.println("\n");
					try {
						taskServerDaemon.stopService();
						System.out.println("server stoped...");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			taskServerDaemon.startService();
			this.statusLabel.setText("Started JBPM5 Server...");
			System.out.println("server started... (ctrl-c to stop it)");
		} catch (Exception e) {
			this.statusLabel.setText("Error starting JBPM5 Server: "
					+ e.getMessage());
			e.printStackTrace(); // TODO show an error
		}
	}

	private void stopJBPM5ServerButtonMouseClicked(MouseEvent evt) {
		System.out.println("stopJBPM5ServerButton.mouseClicked, event=" + evt);
		try {
			taskServerDaemon.stopService();
			this.statusLabel.setText("Stopped JBPM5 Server...");
		} catch (Exception e) {
			this.statusLabel.setText("Coudl not stop JBPM5 server...");
			e.printStackTrace();
		}
	}

	private void startJBPM5ProcessMouseClicked(MouseEvent evt) {
		try {
			this.taskServerDaemon.startSampleInstance();
			this.statusLabel.setText("Started JBPM5 Sample Process...");
		} catch (Exception ex) {
			this.statusLabel.setText("Error starting jbpm5 sample process."
					+ ex.getMessage());
			ex.printStackTrace();
		}
	}

	ActivitiHumanTaskManagement activitiManager = new ActivitiHumanTaskManagement();

	private void startActivitiServerButtonMouseClicked(MouseEvent evt) {
		try {
			System.out.println("startActivitiServerButton.mouseClicked, event="
					+ evt);
			activitiManager.startService();
			this.statusLabel.setText("Started Activiti Server...");
			this.startActivitiServerButton.setEnabled(false);
			this.stopActivitiServerButton.setEnabled(true);
		} catch (RuntimeException e) {
			this.statusLabel.setText("Could not start Activiti Server...");
			e.printStackTrace();
		}
	}

	private void startActivitiSampleButtonMouseClicked(MouseEvent evt) {
		try {
		System.out.println("startActivitiSampleButton.mouseClicked, event="
				+ evt);
		this.statusLabel.setText("Started Activiti Sample Process...");
		this.activitiManager.startSampleInstance();
		}
		catch (RuntimeException e) {
			this.startActivitiSampleButton.setText("Could not start activiti sample process");
			e.printStackTrace();
		}
	}

	private void stopActivitiServerButtonMouseClicked(MouseEvent evt) {
		System.out.println("stopActivitiServerButton.mouseClicked, event="
				+ evt);
		try {
			this.activitiManager.stopService();
			this.stopActivitiServerButton.setEnabled(false);
			this.startActivitiServerButton.setEnabled(true);
			this.statusLabel.setText("Stopped Activiti server...");
		} catch (Exception e) {
			this.statusLabel.setText("Could not stop Activiti server...");
			e.printStackTrace();
		}
	}
	
	private void ActivitiProcessImgMouseClicked(MouseEvent evt) {
		System.out.println("ActivitiProcessImg.mouseClicked, event="+evt);
		JDialog frame = new JDialog(theframe, "Image");
		Panel panel = new ShowImage("activiti-sample.png");
		frame.getContentPane().add(panel);
		frame.setSize(panel.getWidth(), panel.getHeight());
		frame.setVisible(true);
	}

}
