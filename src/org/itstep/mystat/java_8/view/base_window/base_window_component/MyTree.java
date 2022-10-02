package org.itstep.mystat.java_8.view.base_window.base_window_component;

import javax.swing.JOptionPane;
import javax.swing.JTree;

import javax.swing.tree.DefaultMutableTreeNode;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import org.itstep.mystat.java_8.controller.base_window_component_controller.MyTreeMouseAdapter;
import org.itstep.mystat.java_8.exception.CreateMyTreeException;
import org.itstep.mystat.java_8.exception.correct_data_missing_exception.CorrectDataMissingException;
import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class MyTree extends JTree {

	private static final long serialVersionUID = -4492301649598605077L;

	public MyTree(BaseWindow baseWindow) {
		try {
			TreeNode root = new DefaultMutableTreeNode("Содержание", true);
			baseWindow.getDatabaseController().getDatabase().getPartitions().forEach(partition -> {
				TreeNode partitionNode = new DefaultMutableTreeNode(partition.getNumber() + " " + partition.getTitle(),
						true);
				partition.getTopics().forEach(topic -> {
					TreeNode topicNode = new DefaultMutableTreeNode((topic.getNumber() + " " + topic.getTitle()), true);
					addNode(partitionNode, topicNode);
					topic.getQuestions().values().forEach(question -> {
						TreeNode questionNode = new DefaultMutableTreeNode(
								(question.getNumber() + " " + question.getTitle()), true);
						TreeNode answerNode = new DefaultMutableTreeNode((question.getAnswer()), false);
						addNode(questionNode, answerNode);
						addNode(topicNode, questionNode);
					});
				});
				addNode(root, partitionNode);
			});
			setModel(new DefaultTreeModel(root, true));
			addMouseListener(new MyTreeMouseAdapter(baseWindow));
		} catch (CorrectDataMissingException ex) {
			JOptionPane.showMessageDialog(null, (new CreateMyTreeException(ex.getMessage())).getMessage());
			setModel(null);
		}
	}

	private void addNode(TreeNode parentNode, TreeNode childNode) {
		((DefaultMutableTreeNode) parentNode).add((MutableTreeNode) childNode);
	}

}
