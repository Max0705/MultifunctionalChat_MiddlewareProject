package LeftPanel;

//import com.rc.app.Launcher;
import Tools.Colors;
import Tools.GBC;
//import com.rc.components.message.MainOperationPopupMenu;  创建群聊相关的类
//import com.rc.frames.MainFrame;
//import com.rc.frames.SystemConfigDialog;
import Tools.AbstractMouseListener;
import Tools.FontUtil;
import Tools.ParentAvailablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//个人信息，包括名字和头像

public class MyInfoPanel extends ParentAvailablePanel
{
    private static MyInfoPanel context;

    //头像
    private JLabel avatar;
    //名字
    private JLabel username;
    //设置
    //private JLabel menuIcon;
    //private CurrentUserService currentUserService = Launcher.currentUserService;

    //MainOperationPopupMenu mainOperationPopupMenu;
    private String currentUsername;


    public MyInfoPanel(JPanel parent)
    {
        super(parent);
        context = this;

        initComponents();
        //setListeners();
        initView();
    }


    private void initComponents()
    {

        //GImage.setBorder(new SubtleSquareBorder(true));
        //currentUsername = currentUserService.findAll().get(0).getUsername();
        currentUsername="Cindy";
        avatar = new JLabel();
        avatar.setIcon(new ImageIcon("/images/avatar.jpg"));
        //avatar.setIcon(new ImageIcon(AvatarUtil.createOrLoadUserAvatar(currentUsername).getScaledInstance(50,50,Image.SCALE_SMOOTH)));

        avatar.setPreferredSize(new Dimension(50, 50));
        avatar.setCursor(new Cursor(Cursor.HAND_CURSOR));


        username = new JLabel();
        username.setText(currentUsername);
        username.setFont(FontUtil.getDefaultFont(16));
        username.setForeground(Colors.FONT_WHITE);


        //menuIcon = new JLabel();
        //menuIcon.setIcon(new ImageIcon(getClass().getResource("/images/options.png")));
        //menuIcon.setForeground(Colors.FONT_WHITE);
        //menuIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //mainOperationPopupMenu = new MainOperationPopupMenu();
    }

    /*
    private void setListeners()
    {
        menuIcon.addMouseListener(new AbstractMouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    Component component = e.getComponent();
                    mainOperationPopupMenu.show(component, -112, 50);
                    super.mouseClicked(e);
                }

            }
        });


        avatar.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    SystemConfigDialog dialog = new SystemConfigDialog(MainFrame.getContext(), true);
                    dialog.setVisible(true);
                    super.mouseClicked(e);
                }
            }
        });
    }
    */

    private void initView()
    {
        this.setBackground(Colors.DARK);
        this.setLayout(new GridBagLayout());

        add(avatar, new GBC(0, 0).setFill(GBC.NONE).setWeight(2, 1));
        add(username, new GBC(1, 0).setFill(GBC.BOTH).setWeight(7, 1));
        //add(menuIcon, new GBC(2, 0).setFill(GBC.BOTH).setWeight(1, 1));
    }

   /*
   //重设头像
    public void reloadAvatar()
    {
        currentUsername = currentUserService.findAll().get(0).getUsername();
        //Image image = AvatarUtil.createOrLoadUserAvatar(currentUsername);
        //avatar.setImage(image);
        avatar.setIcon(new ImageIcon(AvatarUtil.createOrLoadUserAvatar(currentUsername).getScaledInstance(50,50,Image.SCALE_SMOOTH)));



        avatar.revalidate();
        avatar.repaint();
    }
    */

    public static MyInfoPanel getContext()
    {
        return context;
    }
}
