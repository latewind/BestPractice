package com.latewind.practice.concurrent.gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MinWin extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea;
    private Future task;
    private ExecutorService buttonExecutor= Executors.newCachedThreadPool();

    public MinWin() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancelTask();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        if(task!=null&&!task.isDone()){
         textArea.setText("is Thinking");
            return ;
        }
        textArea.setText("I am LateWind,I will think about 20s");
        task=buttonExecutor.submit(()->{
            try {
                Thread.currentThread().sleep(20000);
                textArea.setText("Who are you");
            } catch (InterruptedException e) {
               textArea.setText("You interrupte me");
            }
        });

        //  dispose();
    }

    private void onCancelTask() {
        // add your code here if necessary
        task.cancel(true);
       // dispose();
    }
    private void onCancel() {
        // add your code here if necessary
        //task.cancel(true);
        dispose();
    }

    public static void main(String[] args) {
        MinWin dialog = new MinWin();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
