package fintrek.expense.service;

import fintrek.expense.core.RegularExpenseManager;
import fintrek.expense.core.RecurringExpenseManager;

public class AppServices {
    public static final ExpenseService REGULAR_SERVICE =
            new ExpenseService(RegularExpenseManager.getInstance());

    public static final ExpenseService RECURRING_SERVICE =
            new ExpenseService(RecurringExpenseManager.getInstance());

    public static final ExpenseReporter REGULAR_REPORTER =
            new ExpenseReporter(RegularExpenseManager.getInstance());

    public static final ExpenseReporter RECURRING_REPORTER =
            new ExpenseReporter(RecurringExpenseManager.getInstance());

    private AppServices() {
        // Prevent instantiation
    }
}
