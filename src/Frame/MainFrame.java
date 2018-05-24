package Frame;

import LeftPanel.LeftPanel;
import RightPanel.RightPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by song on 17-5-28.
 */
public class MainFrame extends JFrame
{
    public static int DEFAULT_WIDTH = 900;
    public static int DEFAULT_HEIGHT = 650;

    public int currentWindowWidth = DEFAULT_WIDTH;
    public int currentWindowHeight = DEFAULT_HEIGHT;

    //private LeftPanel leftPanel;
    private RightPanel rightPanel;

    private static MainFrame context;
    private Image normalTrayIcon; // 正常时的任务栏图标
    private Image emptyTrayIcon; // 闪动时的任务栏图标
    private TrayIcon trayIcon;
    private boolean trayFlashing = false;
    //private AudioStream messageSound; //消息到来时候的提示间


    public MainFrame()
    {
        context = this;
        setVisible(true);
        initComponents();
        initView();

        // 连接WebSocket
       //startWebSocket();
    }

    public static MainFrame getContext()
    {
        return context;
    }


    private void initComponents()
    {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);



        //leftPanel = new LeftPanel();
        //leftPanel.setPreferredSize(new Dimension(260, currentWindowHeight));

        rightPanel = new RightPanel();
    }

    private void initView()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        setListeners();


        //add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        centerScreen();
    }


    /**
     * 使窗口在屏幕中央显示
     */
    private void centerScreen()
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setLocation((tk.getScreenSize().width - currentWindowWidth) / 2,
                (tk.getScreenSize().height - currentWindowHeight) / 2);
    }

    private void setListeners()
    {
        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                currentWindowWidth = (int) e.getComponent().getBounds().getWidth();
                currentWindowHeight = (int) e.getComponent().getBounds().getHeight();
            }
        });
    }

}

