package org.sonar.samples.java.checks;

import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.google.common.collect.ImmutableList;
import com.sun.source.tree.Tree.*;

@Rule(key = "AvoidTooManyParametersForMethod", description = "Method should not have more than 5 parameters", priority = Priority.MAJOR, tags = {"bug"})
public class AvoidTooManyParametersForMethodRule extends IssuableSubscriptionVisitor{

	@Override
	public List<Kind> nodesToVisit() {
		// need to iterate all the methods
		return ImmutableList.of(Tree.Kind.METHOD);
		
	}
	
	public void visitNode(org.sonar.plugins.java.api.tree.Tree tree) {
		MethodTree methodTree = (MethodTree) tree;
		
		MethodSymbol methodSymbol = methodTree.symbol();
		
		if(methodSymbol.parameterTypes().size() > 5) {
			reportIssue(tree, "Too Many Parameters");
		}
	
}

}
