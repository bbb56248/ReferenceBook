package org.itstep.mystat.java_8.controller.all_window_component_controller.base_window_component_controller;

import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.itstep.mystat.java_8.view.base_window.BaseWindow;

public class MyTreeMouseAdapter extends BaseWindowComponentController {

	public MyTreeMouseAdapter(BaseWindow baseWindow) {
		super(baseWindow);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TreePath[] selectionPaths = ((JTree) e.getSource()).getSelectionPaths();
		if (selectionPaths != null) {
			setInitialState();
			TreeNode node;
			for (TreePath selectionPath : selectionPaths) {
				node = (TreeNode) selectionPath.getLastPathComponent();
				if (!node.isLeaf()) {
					getIndexesQuestionsForOneSelections(node);
				}
			}
			if (indexesSelectedQuestions.size() > 0) {
				isQuestionFolderSelected = true;
				baseWindow.getQuestionSelectedLabel().setText(String.valueOf(indexesSelectedQuestions.size()));
				baseWindow.getRestQuestionsLabel().setText(baseWindow.getQuestionSelectedLabel().getText());
			}
		}
	}

//	Рекурсия
	private void getIndexesQuestionsForOneSelections(TreeNode node) {
		if (node.getChildAt(0).isLeaf()) {
			TreeNode topicNode = node.getParent();
			TreeNode partitionNode = topicNode.getParent();
			TreeNode root = partitionNode.getParent();
			int nodeIndexI = root.getIndex(partitionNode);
			int nodeIndexJ = (partitionNode).getIndex(topicNode);
			int nodeIndexK = (topicNode).getIndex(node);
			indexesSelectedQuestions.add(new Integer[] { nodeIndexI, nodeIndexJ, nodeIndexK });
			return;
		}
		Enumeration<? extends TreeNode> childrenNodes = node.children();
		while (childrenNodes.hasMoreElements()) {
			getIndexesQuestionsForOneSelections(childrenNodes.nextElement());
		}
	}

}
