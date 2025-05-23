package fintrek.expense.core;

import fintrek.misc.MessageDisplayer;
import fintrek.util.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages recurring expenses only.
 */
public class RecurringExpenseManager implements ExpenseOperation {
    private static final Logger logger = Logger.getLogger(RecurringExpenseManager.class.getName());

    // Singleton instance
    private static final RecurringExpenseManager instance = new RecurringExpenseManager();

    private final List<Expense> recurringExpenses = new ArrayList<>();

    private RecurringExpenseManager() {}

    public static RecurringExpenseManager getInstance() {
        return instance;
    }

    @Override
    public boolean isRecurring() {
        return true;
    }
    //@@author Charly2312
    @Override
    public void add(Expense expense) {
        assert expense != null : MessageDisplayer.NULL_EXPENSE_ERROR;
        logger.log(Level.FINE, MessageDisplayer.ADDING_REGULAR_EXPENSE_MESSAGE + expense);
        recurringExpenses.add(expense);
    }

    @Override
    public Expense get(int index) {
        assert InputValidator.isInValidIntRange(index, 0, recurringExpenses.size() - 1)
                : MessageDisplayer.INVALID_IDX_MESSAGE;
        return recurringExpenses.get(index);
    }

    @Override
    public Expense remove(int index) {
        assert InputValidator.isInValidIntRange(index, 0, recurringExpenses.size() - 1)
                : MessageDisplayer.INVALID_IDX_MESSAGE;
        Expense removed = recurringExpenses.remove(index);
        logger.log(Level.FINE, String.format(MessageDisplayer.REMOVED_EXPENSE_MESSAGE_TEMPLATE, index, removed));
        return removed;
    }

    @Override
    public int getLength() {
        return recurringExpenses.size();
    }

    @Override
    public List<Expense> getAll() {
        return new ArrayList<>(recurringExpenses); // defensive copy
    }

    @Override
    public void clear() {
        recurringExpenses.clear();
        logger.log(Level.FINE, MessageDisplayer.CLEARED_ALL_REGULAR_EXPENSES_MESSAGE);
    }

    @Override
    public void insertAt(int index, Expense expense) {
        assert InputValidator.isInValidIntRange(index, 0, recurringExpenses.size())
                : MessageDisplayer.INVALID_IDX_MESSAGE;
        logger.log(Level.FINE, String.format(MessageDisplayer.INSERTING_EXPENSE_MESSAGE_TEMPLATE, index, expense));
        recurringExpenses.add(index, expense);
    }
}
