
package gherkinexecutor;

import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

    public class TestTagFilter {

        @Test
        void testNoTag() {
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@A"),""),  "Should execute when no filer");
        }
        @Test
        void testSingleTag() {
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@A"), "@A"), "Should execute when @A is present");
            assertFalse(Translate.TagFilterEvaluator.shouldExecute(Set.of("@B"), "@A"), "Should NOT execute when @A is missing");
        }

        @Test
        void testAndCondition() {
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@A", "@B"), "@A AND @B"), "Should execute when @A and @B are present");
            assertFalse(Translate.TagFilterEvaluator.shouldExecute(Set.of("@A"), "@A AND @B"), "Should NOT execute when @B is missing");
            assertFalse(Translate.TagFilterEvaluator.shouldExecute(Set.of("@B"), "@A AND @B"), "Should NOT execute when @A is missing");
        }

        @Test
        void testOrCondition() {
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@A"), "@A OR @B"), "Should execute when @A is present");
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@B"), "@A OR @B"), "Should execute when @B is present");
            assertFalse(Translate.TagFilterEvaluator.shouldExecute(Set.of("@C"), "@A OR @B"), "Should NOT execute when neither @A nor @B is present");
        }

        @Test
        void testNotCondition() {
            assertFalse(Translate.TagFilterEvaluator.shouldExecute(Set.of("@A"), "NOT @A"), "Should NOT execute when @A is present");
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@B"), "NOT @A"), "Should execute when @A is missing");
            assertFalse(Translate.TagFilterEvaluator.shouldExecute(Set.of("@B", "@C"), "NOT @B"), "Should NOT execute when @B is present");
        }

        @Test
        void testComplexExpression() {
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@A", "@B"), "@A AND @B OR @C"), "Should execute when @A and @B are present");
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@C"), "@A AND @B OR @C"), "Should execute when @C is present");
            assertFalse(Translate.TagFilterEvaluator.shouldExecute(Set.of("@D"), "@A AND @B OR @C"), "Should NOT execute when no valid group matches");

            assertFalse(Translate.TagFilterEvaluator.shouldExecute(Set.of("@A", "@B"), "NOT @A AND NOT @B"), "Should NOT execute when both @A and @B are present");
            assertTrue(Translate.TagFilterEvaluator.shouldExecute(Set.of("@C"), "NOT @A AND NOT @B"), "Should execute when @A and @B are missing");
        }
    }

