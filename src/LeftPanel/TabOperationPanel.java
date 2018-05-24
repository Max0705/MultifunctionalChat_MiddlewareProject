package LeftPanel;

import Tools.Colors;
import Tools.GBC;
import Tools.RCBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Tools.ParentAvailablePanel;


//好友和群聊图标
public class TabOperationPanel extends ParentAvailablePanel
{
    private JLabel chatLabel;
    private JLabel contactsLabel;
    private JLabel meLable;
    private TabItemClickListener clickListener;
    private ImageIcon chatIconActive;
    private ImageIcon chatIconNormal;
    private ImageIcon contactIconNormal;
    private ImageIcon contactIconActive;
    private ImageIcon meIconNormal;
    private ImageIcon meIconActive;

    private LeftPanel parent;

    public TabOperationPanel(JPanel parent)
    {
        super(parent);

        initComponents();
        initView();
    }



    private void initComponents()
    {
        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        clickListener = new TabItemClickListener();
        RCBorder rcBorder = new RCBorder(RCBorder.RIGHT);
        rcBorder.setHeightScale(0.2F);

        //联系人列表图表
        chatIconActive = new ImageIcon(getClass().getResource("/images/chat_active.png"));
        chatIconNormal = new ImageIcon(getClass().getResource("/images/chat_normal.png"));
        chatLabel = new JLabel();
        chatLabel.setIcon(chatIconActive);
        chatLabel.setBorder(rcBorder);
        chatLabel.setHorizontalAlignment(JLabel.CENTER);
        chatLabel.setCursor(handCursor);
        chatLabel.addMouseListener(clickListener);

        //群聊列表图表
        contactIconNormal = new ImageIcon(getClass().getResource("/images/contacts_normal.png"));
        contactIconActive = new ImageIcon(getClass().getResource("/images/contacts_active.png"));
        contactsLabel = new JLabel();
        contactsLabel.setIcon(contactIconNormal);
        contactsLabel.setBorder(rcBorder);
        contactsLabel.setHorizontalAlignment(JLabel.CENTER);
        contactsLabel.setCursor(handCursor);
        contactsLabel.addMouseListener(clickListener);

        //收藏列表图标，暂时不考虑
        /*
        meIconNormal = new ImageIcon(getClass().getResource("/image/me_normal.png"));
        meIconActive = new ImageIcon(getClass().getResource("/image/me_active.png"));
        meLable = new JLabel();
        meLable.setIcon(meIconNormal);
        meLable.setHorizontalAlignment(JLabel.CENTER);
        meLable.setCursor(handCursor);
        meLable.addMouseListener(clickListener);
        */
        parent = (LeftPanel) getParentPanel();
    }

    private void initView()
    {
        setLayout(new GridBagLayout());
        setBackground(Colors.DARK);
        setBorder(new RCBorder(RCBorder.BOTTOM));
        add(chatLabel, new GBC(0, 0).setFill(GBC.HORIZONTAL).setWeight(1,1).setInsets(0,10,0,10));
        add(contactsLabel, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(1,1).setInsets(0,10,0,10));
        //add(meLable, new GBC(2, 0).setFill(GBC.HORIZONTAL).setWeight(1,1).setInsets(0,10,0,10));
    }

    @Override
    protected void printBorder(Graphics g)
    {
        super.printBorder(g);
    }


    class TabItemClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // 搜索框内容清空
            //SearchPanel.getContext().clearSearchText();

            if (e.getComponent() == chatLabel) {
                chatLabel.setIcon(chatIconActive);
                contactsLabel.setIcon(contactIconNormal);
                //meLable.setIcon(meIconNormal);
                parent.getListPanel().showPanel(ListPanel.CHAT);

            } else if (e.getComponent() == contactsLabel) {
                chatLabel.setIcon(chatIconNormal);
                contactsLabel.setIcon(contactIconActive);
                //meLable.setIcon(meIconNormal);
                parent.getListPanel().showPanel(ListPanel.CONTACTS);
            } else if (e.getComponent() == meLable) {
                chatLabel.setIcon(chatIconNormal);
                contactsLabel.setIcon(contactIconNormal);
                //meLable.setIcon(meIconActive);
                parent.getListPanel().showPanel(ListPanel.COLLECTIONS);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
