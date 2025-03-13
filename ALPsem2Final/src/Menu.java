import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    private Account user;
    private ArrayList<Account> userlist = new ArrayList<>();
    private LinkedList<Items> itemsList = new LinkedList<>();
    private Queue unvalidatedOrdersQueue = new Queue();
    private Queue validatedOrdersQueue = new Queue();
    private Cart cart = new Cart(this);
    private Set<Integer> usedOrderIds = new HashSet<>();
    private Random random = new Random();
    private static final String USER_FILE_NAME = "users.ser";
    private static final String ITEMS_FILE_NAME = "items.ser";
    private static final String ORDERS_FILE_NAME = "orders.ser";
    private static final String UNVALIDATED_ORDERS_FILE_NAME = "unvalidatedOrders.ser";
    private static final String CART_FILE_NAME = "carts.ser";
    private ArrayList<Cart> cartList = new ArrayList<>();

    private String bankName;
    private String bankAccountNumber;
    private static final String BANK_DETAILS_FILE_NAME = "bankDetails.ser";

    public Menu() {
        loadUsersFromFile();
        loadItemsFromFile();
        loadOrdersFromFile();
        loadUnvalidatedOrdersFromFile();
        loadCartsFromFile();
        loadBankDetailsFromFile();
        cart.setMenu(this);
        menu();
    }

    public void gotomenu() {
        if (user.getClass().equals(Customer.class)) {
            loadUserCart(); // Load the cart for curernt user
            customerMenu();
        } else if (user.getClass().equals(Admin.class)) {
            adminMenu();
        } else {
            System.out.println("Invalid account type.");
        }
    }

    private void customerMenu() {
        Scanner s = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n\nWelcome, " + user.getusername());
            System.out.println("What do you want to PreOrder today?");
            System.out.println("Customer Menu:");
            System.out.println("1. View Available Items");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View/Delete Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Check Order History");
            System.out.println("6. Edit Information");
            System.out.println("7. Logout");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
System.out.print("Choose: ");
String choice = s.nextLine().trim();

            switch (choice) {
                case "1":
                    viewAvailableItems();
                    break;
                case "2":
                    addItemToCart();
                    break;
                case "3":
                    viewOrdeleteCart();
                    break;
                case "4":
                    checkout();
                    break;
                case "5":
                    checkOrderHistory();
                    break;
                case "6":
                    editUserInfo();
                    break;
                case "7":
                    saveUserCart();
                    menu();
                    break;
                case "8":
                    saveUsersToFile();
                    saveItemsToFile();
                    saveOrdersToFile();
                    saveUserCart();
                    saveCartsToFile();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }  

    private void viewAvailableItems() {
        Scanner s = new Scanner(System.in);
        String input = "";
    
        do {
            System.out.println("\nAvailable Items:");
            for (Items item : itemsList) {
                if ("open".equalsIgnoreCase(item.getStatus())) {
                    System.out.println("ID: " + item.getItemID() + " | Brand: " + item.getBrand() + " | Name: " + item.getName());
                }
            }
            System.out.print("Enter ID to view details or '00' to return: ");
            input = s.next().trim();
    
            if (!"00".equalsIgnoreCase(input)) {
                viewItemDetailsCustomer(input);
                System.out.print("\nView another item? (Y/N): ");
                input = s.next().trim();
                while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")){
                    System.out.print("Input can only be Y/N! View another item? (Y/N): ");
                    input = s.next().trim();
                }
            }
        } while (!"N".equalsIgnoreCase(input) && "Y".equalsIgnoreCase(input));
    }
    
    private void viewItemDetailsCustomer(String itemId) {
        Items item = getItemById(itemId);
        if (item != null && "open".equalsIgnoreCase(item.getStatus())) {
            System.out.println("\nItem Details:");
            System.out.println("ID: " + item.getItemID());
            System.out.println("Brand: " + item.getBrand());
            System.out.println("Name: " + item.getName());
            System.out.println("Scale: " + item.getScale());
            System.out.println("Description: " + item.getDescription());
            System.out.println("Price: Rp. " + item.getPrice());
            System.out.println("DP Price: Rp. " + item.getDp_price());
            System.out.println("Max PO Date: " + item.getMaxPODate());
            System.out.println("Estimated Time of Arrival: " + item.getEstimatedTimeOfArrival());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Item not found or not available for viewing.");
        }
    }
    

    private void addItemToCart() {
        String yesno = "y";
        while (yesno.equalsIgnoreCase("y")) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nAdd Item to Cart:");
        for (Items item : itemsList) {
            if ("open".equalsIgnoreCase(item.getStatus())) {
                System.out.println("ID: " + item.getItemID() + " | Brand: " + item.getBrand() + " | Name: " + item.getName() + " | Price: Rp. " + item.getPrice() + " | DP: Rp. " + item.getDp_price());
            }
        }
        System.out.print("Enter Item ID (00 to Cancel): ");
        String itemId = s.next();
            if (itemId.equalsIgnoreCase("00")){
                System.out.println("Cancelling...");
                return;
            }
        Items item = getItemById(itemId);
        if (item == null || !"open".equalsIgnoreCase(item.getStatus())) {
            System.out.println("Item not found or not available.");
            return;
        }
        System.out.print("Enter Quantity: ");
        int quantity = s.nextInt();
        if (quantity > item.getSlots()) {
            System.out.println("Not enough slots available.");
            return;
        }
        OrderDetail detail = new OrderDetail(cart.getCartItems().size() + 1, -1, itemId, quantity);
        cart.addItem(detail);
        System.out.println("Item added to cart successfully!");

        System.out.print("Add more items? (Y/N): ");
        yesno = s.next()+s.nextLine();
            while (!yesno.equalsIgnoreCase("Y") && !yesno.equalsIgnoreCase("N")){
                System.out.print("Input can only be Y/N! Add another item? (Y/N): ");
                yesno = s.next().trim();
            }
        }
    }

    private void viewOrdeleteCart(){
        Scanner s = new Scanner(System.in);
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }
        System.out.println("\n=== View or Delete Cart ===");
        System.out.println("1. View Cart");
        System.out.println("2. Delete Cart");
        System.out.print("Choose: ");
        String choice = s.next()+s.nextLine();
        switch (choice){
            case "1":
            viewCart();
            break;

            case "2":
            deleteCart();
            break;

            default:
            System.out.println("Input not valid");
            return;
        }
    }

    private void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        System.out.println("\nCart Items:");
        for (OrderDetail detail : cart.getCartItems()) {
            Items item = getItemById(detail.getItemID());
            System.out.println("ID: " + item.getItemID());
            System.out.println("Brand: " + item.getBrand());
            System.out.println("Name: " + item.getName());
            System.out.println("Quantity: " + detail.getQuantity());
            System.out.println("DP Price: Rp. " + item.getDp_price());
            System.out.println("-----------------------------");
        }
        double totalDp = cart.calculateTotalDp();
        System.out.println("Total DP to be paid: Rp. " + totalDp);
    }

    private void deleteCart() {
        Scanner s = new Scanner(System.in);
        viewCart();
        System.out.print("\nAre you sure you want to delete contents of your cart? (Y/N): ");
        String input = s.next().trim();
        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")){
            System.out.print("Input can only be Y/N! Delete Cart? (Y/N): ");
            input = s.next().trim();
        }
        if (input.equalsIgnoreCase("y")){
            System.out.println("Clearing cart....");
            cart.clearCart();
        } else if (input.equalsIgnoreCase("n")){
            System.out.println("Cancelling......");
        }
    }

    private void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Please add items before checking out.");
            return;
        }
        Scanner s = new Scanner(System.in);
        double totalDp = cart.calculateTotalDp(); // Calculate the total DP
        double totalPrice = cart.calculateTotalPrice(); // Calculate the total price
        double totalFinal = totalPrice - totalDp; // Calculate the final total payment
        
        System.out.println("\nTotal DP to be paid: Rp. " + totalDp);
        System.out.println("Please transfer to the following bank account:");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Bank Account Number: " + bankAccountNumber);
        System.out.print("Enter your bank name: ");
        String dpBank = s.next();
        System.out.print("Enter transaction number: ");
        String transactionNumber = s.next();
    
        if (transactionNumber.length() < 5) {
            System.out.println("Invalid transaction number.");
            return;
        }
    
        int orderId = generateUniqueOrderId();
        Order order = new Order(orderId, user.getusername(), java.time.LocalDate.now().toString(), totalDp, totalFinal, true, false, "waiting confirmation", dpBank, transactionNumber);
        for (OrderDetail detail : cart.getCartItems()) {
            detail.setOrderId(order.getId());
            order.addOrderDetail(detail);
        }
        unvalidatedOrdersQueue.enqueue(order);
        saveUnvalidatedOrdersToFile();
        ((Customer) user).addOrder(order); // add order to cust list
        cart.clearCart(); // Clear cart after input orders
        saveUserCart(); // empty cart is saved
        System.out.println("Order placed and awaiting admin validation! Your Order ID: " + orderId);
    }


    private int generateUniqueOrderId() {
        int orderId;
        do {
            orderId = 10000 + random.nextInt(90000);  
        } while (usedOrderIds.contains(orderId));
        usedOrderIds.add(orderId);  
        return orderId;
    }
    
    private void checkOrderHistory() {
        System.out.println("\nOrder History:");
        boolean found = false;
        boolean awaitingFinalPayment = false;

        System.out.println("\nPending Validation:");
        found = displayOrderHistory(unvalidatedOrdersQueue, false) || found;

        System.out.println("\nValidated Orders:");
        found = displayOrderHistory(validatedOrdersQueue, true) || found;
    
        // Check orders awaiting final payment
        awaitingFinalPayment = checkAwaitingFinalPayment();

        if (!found) {
            System.out.println("No order history found for the user.");
        } else if (awaitingFinalPayment) {
            handleFinalPayment();
        }
    }
    
    private boolean displayOrderHistory(Queue queue, boolean showPrompt) {
        Queue tempQueue = new Queue();
        boolean found = false;
    
        while (!queue.isEmpty()) {
            Order order = (Order) queue.dequeue();
            tempQueue.enqueue(order);
            if (order.getUsername().equals(user.getusername())) {
                found = true;
                System.out.println("Order ID: " + order.getId());
                System.out.println("Order Date: " + order.getOrderDate());
                System.out.println("Total DP: Rp. " + order.getTotalDp());
                if (order.getStatus().equals("awaiting delivery") || order.getStatus().equals("in delivery") || order.getStatus().equals("completed")){
                    System.out.println("Full Payment: Rp. " + order.getTotalFinal());
                    System.out.println("Total Payment: Rp. " + (order.getTotalFinal() + order.getTotalDp()));
                }
                System.out.println("Status: " + order.getStatus());
                if (order.getTrackingNumber() != null) {
                    System.out.println("Tracking Number: " + order.getTrackingNumber());
                }
                System.out.println("Contents: ");
                for (OrderDetail detail : order.getOrderDetails()) {
                    Items item = getItemById(detail.getItemID());
                    System.out.println("  Item ID: " + item.getItemID());
                    System.out.println("  Name: " + item.getName());
                    System.out.println("  Quantity: " + detail.getQuantity());
                    System.out.println("-----");
                }
                if ("in delivery".equals(order.getStatus())) {
                    System.out.print("Change status to Completed? (Y/N): ");
                    Scanner s = new Scanner(System.in);
                    String input = s.next();
                    if ("Y".equalsIgnoreCase(input)) {
                        order.setStatus("completed");
                        System.out.println("Order status updated to Completed.");
                    }
                }
                System.out.println("-----------------------------");
    
                //if there is order waiting final payment
                if (showPrompt && "final payment".equals(order.getStatus())) {
                    System.out.println("Order ID " + order.getId() + " is awaiting final payment.");
                }
            }
        }

        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
        return found;
    }

    private boolean checkAwaitingFinalPayment() {
        Queue tempQueue = new Queue();
        boolean awaitingFinalPayment = false;

        while (!validatedOrdersQueue.isEmpty()) {
            Order order = (Order) validatedOrdersQueue.dequeue();
            tempQueue.enqueue(order);
            if (order.getUsername().equals(user.getusername()) && "final payment".equals(order.getStatus())) {
                awaitingFinalPayment = true;
            }
        }
    
        //Restore validated queue
        while (!tempQueue.isEmpty()) {
            validatedOrdersQueue.enqueue(tempQueue.dequeue());
        }
    
        return awaitingFinalPayment;
    }
    
    
    public Items getItemById(String itemId) {
        for (Items item : itemsList) {
            if (item.getItemID().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    private void handleFinalPayment() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your Order ID for final payment: ");
        int orderId = s.nextInt();
        Order orderToPay = null;
        Queue tempQueue = new Queue();
    
        while (!validatedOrdersQueue.isEmpty()) {
            Order order = (Order) validatedOrdersQueue.dequeue();
            tempQueue.enqueue(order);
            if (order.getId() == orderId && order.getUsername().equals(user.getusername()) && "final payment".equals(order.getStatus())) {
                orderToPay = order;
            }
        }
        validatedOrdersQueue = tempQueue;
    
        if (orderToPay == null) {
            System.out.println("Order not found or not valid for final payment.");
            return;
        }
    
        System.out.println("Total Final Payment to be paid: Rp. " + orderToPay.getTotalFinal());
        System.out.print("Enter bank used for final payment: ");
        String finalBank = s.next();
        System.out.print("Enter final payment transaction number: ");
        String transactionNumber = s.next();
    
        if (transactionNumber.length() < 5) {
            System.out.println("Invalid transaction number.");
            return;
        }
    
        orderToPay.setFinalPaid(true);
        orderToPay.setFinalBank(finalBank);
        orderToPay.setFinalTransactionNumber(transactionNumber);
        orderToPay.setStatus("waiting final validation");
        saveOrdersToFile();
        System.out.println("Final payment made. Awaiting admin validation.");
    }    

    private void adminMenu() {
        Scanner s = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            promptForBankDetailsIfAbsent();
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Manage Orders");
            System.out.println("2. Manage Items");
            System.out.println("3. Check All Customers");
            System.out.println("4. Edit Bank Account Details");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Pilih: ");
            String choice = s.next()+s.nextLine();

            switch (choice) {
                case "1":
                    manageOrders();
                    break;
                case "2":
                    manageItems();
                    break;
                case "3":
                    viewCustomerOrderStatistics();
                    break;
                case "4":
                    editBankAccountDetails();
                    break;
                case "5":
                    saveUsersToFile();
                    saveItemsToFile();
                    saveOrdersToFile();
                    menu();
                    return;
                case "6":
                    saveUsersToFile();
                    saveItemsToFile();
                    saveOrdersToFile();
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void promptForBankDetailsIfAbsent() {
        if (bankName == null || bankAccountNumber == null || bankName.isEmpty() || bankAccountNumber.isEmpty()) {
            System.out.println("Bank account details are not set. Please enter the details.");
            setBankAccountDetails();
        }
    }

    private void manageOrders() {
        Scanner s = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nManage Orders:");
            System.out.println("1. View Unvalidated Orders");
            System.out.println("2. View All Validated Orders");
            System.out.println("3. Validate Orders");
            System.out.println("4. Change Order Status");
            System.out.println("5. Delete Orders");
            System.out.println("0. Back to Admin Menu");
            System.out.print("Choose an option: ");
            String choice = s.next() + s.nextLine();
    
            switch (choice) {
                case "1":
                    viewUnvalidatedOrders();
                    break;
                case "2":
                    viewAllOrders();
                    break;
                case "3":
                    validateOrDeleteOrders();
                    break;
                case "4":
                    changeOrderStatus();
                    break;
                case "5":
                    deleteAnyOrder();
                    break;
                case "0":
                adminMenu();
                return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void viewUnvalidatedOrders() {
        Scanner s = new Scanner(System.in);
        
        if (unvalidatedOrdersQueue.isEmpty()) {
            System.out.println("No unvalidated orders.");
            return;
        }
    
        System.out.println("\nUnvalidated Orders:");
        Queue tempQueue = new Queue();
        boolean found = false;
    
        while (!unvalidatedOrdersQueue.isEmpty()) {
            Order order = (Order) unvalidatedOrdersQueue.dequeue();
            tempQueue.enqueue(order);
            System.out.println("Order ID: " + order.getId() + " | User ID: " + order.getUsername() + " | Order Date: " + order.getOrderDate());
            found = true;
        }
    
        if (!found) {
            System.out.println("No unvalidated orders found.");
            return;
        }
    
        System.out.print("Enter Order ID to view details (00 to cancel): ");
        int orderId = s.nextInt();
            if (orderId == 00){
                return;
            }
        viewOrderDetailsById(tempQueue, orderId);
    
        //Restore nvalidated queue
        while (!tempQueue.isEmpty()) {
            unvalidatedOrdersQueue.enqueue(tempQueue.dequeue());
        }
    }

    private void viewUnvalidatedOrdersSimplified() {
        if (unvalidatedOrdersQueue.isEmpty()) {
            System.out.println("No unvalidated orders.");
            return;
        }
        System.out.println("\nUnvalidated Orders:");
        Queue tempQueue = new Queue();
        while (!unvalidatedOrdersQueue.isEmpty()) {
            Order order = (Order) unvalidatedOrdersQueue.dequeue();
            tempQueue.enqueue(order);
            System.out.println("Order ID: " + order.getId() + " | User ID: " + order.getUsername() + " | Order Date: " + order.getOrderDate());
        }
        unvalidatedOrdersQueue = tempQueue;
    }
    
    private void validateOrDeleteOrders() {
        Scanner s = new Scanner(System.in);
        if (unvalidatedOrdersQueue.isEmpty() && validatedOrdersQueue.isEmpty()) {
            System.out.println("No orders to validate or delete.");
            return;
        }
        
        viewUnvalidatedOrdersSimplified();
    
        System.out.println("Orders Waiting Final Validation:");
        Queue tempQueue = new Queue();
        boolean found = false;
        while (!validatedOrdersQueue.isEmpty()) {
            Order order = (Order) validatedOrdersQueue.dequeue();
            tempQueue.enqueue(order);
            if ("waiting final validation".equals(order.getStatus())) {
                System.out.println("Order ID: " + order.getId() + " | User ID: " + order.getUsername() + " | Order Date: " + order.getOrderDate());
                found = true;
            }
        }
        validatedOrdersQueue = tempQueue;
    
        if (!found) {
            System.out.println("No orders waiting for final validation.");
        }
    
        System.out.print("\nEnter Order ID to view details and validate or delete (00 to cancel): ");
        int orderId = s.nextInt();
            if (orderId == 00){
                System.out.println("Cancelling.....");
                return;
            }
        boolean orderFound = false;
    
        tempQueue = new Queue();
        while (!unvalidatedOrdersQueue.isEmpty()) {
            Order order = (Order) unvalidatedOrdersQueue.dequeue();
            if (order.getId() == orderId) {
                displayOrderDetails(order); // Display order details
                System.out.print("Enter 'V' to validate or 'D' to delete: ");
                String action = s.next().toUpperCase();
                if (action.equals("V")) {
                    order.setStatus("in process");
                    validatedOrdersQueue.enqueue(order);
                    System.out.println("Order validated and moved to validated queue.");
                } else if (action.equals("D")) {
                    Account customer = getUserByUsername(order.getUsername());
                    if (customer != null && customer instanceof Customer) {
                        ((Customer) customer).removeOrder(order);
                    }
                    System.out.println("Order deleted.");
                } else {
                    tempQueue.enqueue(order);
                    System.out.println("Invalid input. Order not processed.");
                }
                orderFound = true;
            } else {
                tempQueue.enqueue(order);
            }
        }
    
        // Restore unvalidated orders
        while (!tempQueue.isEmpty()) {
            unvalidatedOrdersQueue.enqueue(tempQueue.dequeue());
        }
    
        // Validate or delete final payment orders
        tempQueue = new Queue();
        while (!validatedOrdersQueue.isEmpty()) {
            Order order = (Order) validatedOrdersQueue.dequeue();
            if (order.getId() == orderId && "waiting final validation".equals(order.getStatus())) {
                displayOrderDetails(order); //Display order details
                System.out.print("Enter 'V' to validate final payment or 'D' to delete: ");
                String action = s.next().toUpperCase();
                if (action.equals("V")) {
                    order.setStatus("awaiting delivery");
                    validatedOrdersQueue.enqueue(order);
                    System.out.println("Final payment validated. Order status changed to Awaiting Delivery.");
                } else if (action.equals("D")) {
                    Account customer = getUserByUsername(order.getUsername());
                    if (customer != null && customer instanceof Customer) {
                        ((Customer) customer).removeOrder(order);
                    }
                    System.out.println("Order deleted.");
                } else {
                    tempQueue.enqueue(order);
                    System.out.println("Invalid input. Order not processed.");
                }
                orderFound = true;
            } else {
                tempQueue.enqueue(order);
            }
        }
    
        // Restore validated orders
        while (!tempQueue.isEmpty()) {
            validatedOrdersQueue.enqueue(tempQueue.dequeue());
        }
    
        if (!orderFound) {
            System.out.println("Order ID not found.");
        } else {
            saveUnvalidatedOrdersToFile();
            saveOrdersToFile();
        }
    }

    private void viewAllOrders() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nView Orders:");
        System.out.println("1. View All Validated Orders");
        System.out.println("2. View Orders In Process");
        System.out.println("3. View Orders Awaiting Final Payment");
        System.out.println("4. View Orders Awaiting Final Validation");
        System.out.println("5. View Orders Awaiting Delivery");
        System.out.println("6. View Orders In Delivery");
        System.out.println("7. View Completed Orders");
        System.out.println("0. Back to Manage Orders");
        System.out.print("Choose an option: ");
        String choice = s.next();
    
        Queue tempQueue = new Queue();
        boolean found = false;
    
        switch (choice) {
            case "1":
                System.out.println("\nAll Validated Orders:");
                found = displayOrdersWithMinimalInfo(validatedOrdersQueue, tempQueue) || found;
                break;
            case "2":
                System.out.println("\nOrders In Process:");
                found = displayOrdersWithMinimalInfoByStatus(validatedOrdersQueue, tempQueue, "in process") || found;
            break;
            case "3":
                System.out.println("\nOrders Awaiting Final Payment:");
                found = displayOrdersWithMinimalInfoByStatus(validatedOrdersQueue, tempQueue, "final payment") || found;
                break;
            case "4":
                System.out.println("\nOrders Awaiting Final Validation:");
                found = displayOrdersWithMinimalInfoByStatus(validatedOrdersQueue, tempQueue, "waiting final validation") || found;
            break;
            case "5":
                System.out.println("\nOrders Awaiting Delivery:");
                found = displayOrdersWithMinimalInfoByStatus(validatedOrdersQueue, tempQueue, "awaiting delivery") || found;
                break;
            case "6":
                System.out.println("\nOrders In Delivery:");
                found = displayOrdersWithMinimalInfoByStatus(validatedOrdersQueue, tempQueue, "in delivery") || found;
                break;
            case "7":
                System.out.println("\nCompleted Orders:");
                found = displayOrdersWithMinimalInfoByStatus(validatedOrdersQueue, tempQueue, "completed") || found;
                break;
            case "0":
                System.out.println("Returning to Manage Orders......");
                manageOrders();
                return;
            default:
                System.out.println("Invalid choice.");
                return;
        }
    
        if (!found) {
            System.out.println("No orders found for the selected option.");
        } else {
            System.out.print("Enter Order ID to view details: ");
            int orderId = s.nextInt();
            viewOrderDetailsById(tempQueue, orderId);
        }
    
        // Restore validated queue
        while (!tempQueue.isEmpty()) {
            validatedOrdersQueue.enqueue(tempQueue.dequeue());
        }
    }

    private boolean displayOrdersWithMinimalInfo(Queue queue, Queue tempQueue) {
        boolean found = false;
        while (!queue.isEmpty()) {
            Order order = (Order) queue.dequeue();
            tempQueue.enqueue(order);
            System.out.println("Order ID: " + order.getId() + " | User ID: " + order.getUsername() + " | Order Date: " + order.getOrderDate());
            found = true;
        }
        return found;
    }
    
    private boolean displayOrdersWithMinimalInfoByStatus(Queue queue, Queue tempQueue, String status) {
        boolean found = false;
        while (!queue.isEmpty()) {
            Order order = (Order) queue.dequeue();
            if (order.getStatus().equalsIgnoreCase(status)) {
                tempQueue.enqueue(order);
                System.out.println("Order ID: " + order.getId() + " | User ID: " + order.getUsername() + " | Order Date: " + order.getOrderDate());
                found = true;
            } else {
                tempQueue.enqueue(order);
            }
        }
        return found;
    }
    
    private void viewOrderDetailsById(Queue tempQueue, int orderId) {
        boolean found = false;
        Queue detailsQueue = new Queue();
    
        while (!tempQueue.isEmpty()) {
            Order order = (Order) tempQueue.dequeue();
            detailsQueue.enqueue(order);
            if (order.getId() == orderId) {
                System.out.println("\nOrder Details:");
                displayOrderDetails(order);
                found = true;
            }
        }
    
        // Restore the tempQueue
        while (!detailsQueue.isEmpty()) {
            tempQueue.enqueue(detailsQueue.dequeue());
        }
    
        if (!found) {
            System.out.println("Order ID not found.");
        }
    }

    private void displayOrderDetails(Order order) {
        System.out.println("Order ID: " + order.getId());
        System.out.println("Username: " + order.getUsername());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Total DP: Rp. " + order.getTotalDp());
        System.out.println("Total Final: Rp. " + order.getTotalFinal());
        System.out.println("Bank for DP: "+ order.getDpBank());
        System.out.println("DP Transaction Number: " + order.getDpTransactionNumber());
        if (order.getFinalTransactionNumber() != null) {
            System.out.println("Bank for Final Payment: " + order.getFinalBank());
            System.out.println("Final Payment Transaction Number: " + order.getFinalTransactionNumber());
        }
        if (order.getTrackingNumber() != null) {
            System.out.println("Tracking Number: " + order.getTrackingNumber());
        }
        System.out.println("Status: " + order.getStatus());
        System.out.println("-----------------------------");
    }
    

    private void changeOrderStatus() {
        Scanner s = new Scanner(System.in);
        Queue combinedQueue = new Queue();
        boolean found = false;
    
        // Display all orders
        System.out.println("\nAll Orders (except completed):");
        Queue tempQueue = new Queue();
        
        for (Queue queue : new Queue[]{validatedOrdersQueue, unvalidatedOrdersQueue}) {
            while (!queue.isEmpty()) {
                Order order = (Order) queue.dequeue();
                tempQueue.enqueue(order);
                if (!"completed".equals(order.getStatus()) && !"waiting confirmation".equals(order.getStatus())) {
                    System.out.println("Order ID: " + order.getId() + " | User ID: " + order.getUsername() + " | Order Date: " + order.getOrderDate() + " | Status: " + order.getStatus());
                    found = true;
                }
            }
    
            //Restore queue
            while (!tempQueue.isEmpty()) {
                queue.enqueue(tempQueue.dequeue());
            }
        }
    
        if (!found) {
            System.out.println("No orders available for status change.");
            return;
        }
    
        System.out.print("\nEnter Order ID to view details (00 to cancel): ");
        int orderId = s.nextInt();
            if (orderId == 00){
                System.out.println("Cancelling....");
                return;
            }
        s.nextLine();
    
        Order orderToChange = null;
        for (Queue queue : new Queue[]{validatedOrdersQueue, unvalidatedOrdersQueue}) {
            while (!queue.isEmpty()) {
                Order order = (Order) queue.dequeue();
                combinedQueue.enqueue(order);
                if (order.getId() == orderId) {
                    orderToChange = order;
                }
            }
    
            // Restore the queue
            while (!combinedQueue.isEmpty()) {
                queue.enqueue(combinedQueue.dequeue());
            }
        }
    
        if (orderToChange == null) {
            System.out.println("Order not found or not valid for status change.");
            return;
        }
    
        // Display order details
        displayOrderDetails(orderToChange);
        System.out.println("1. Change to Final Payment");
        System.out.println("2. Change to Awaiting Delivery");
        System.out.println("3. Set Tracking Number for Delivery");
        System.out.println("4. Change to Completed");
        System.out.println("0. Cancel");
        System.out.print("Choose: ");
        String choice = s.next();
        s.nextLine();
    
        switch (choice) {
            case "1":
                if ("in process".equals(orderToChange.getStatus())) {
                    orderToChange.setStatus("final payment");
                    System.out.println("Order status changed to Final Payment.");
                } else {
                    System.out.println("Order is not in the correct status to set to Final Payment.");
                }
                break;
            case "2":
                if ("final payment".equals(orderToChange.getStatus()) && orderToChange.isFinalPaid()) {
                    orderToChange.setStatus("awaiting delivery");
                    System.out.println("Order status changed to Awaiting Delivery.");
                } else {
                    System.out.println("Final payment not made or already in delivery.");
                }
                break;
            case "3":
                if ("awaiting delivery".equals(orderToChange.getStatus())) {
                    System.out.print("Enter Tracking Number: ");
                    String trackingNumber = s.nextLine();
                    orderToChange.setTrackingNumber(trackingNumber);
                    orderToChange.setStatus("in delivery");
                    System.out.println("Tracking number set for the order and status changed to In Delivery.");
                } else {
                    System.out.println("Order is not in the correct status to set a tracking number.");
                }
                break;
            case "4":
                if ("in delivery".equals(orderToChange.getStatus())) {
                    orderToChange.setStatus("completed");
                    System.out.println("Order status changed to Completed.");
                } else {
                    System.out.println("Order is not in the correct status to be completed.");
                }
                break;
            case "0":
                System.out.println("Order remains unchanged.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
        saveOrdersToFile();
    }
    
    
    private void deleteAnyOrder() {
        Scanner s = new Scanner(System.in);
        System.out.println("Delete Any Order:");
        boolean found = false;
    
        // Display all orders (table format)
        System.out.println("\nAll Orders:");
        System.out.printf("%-10s %-20s %-15s %-20s\n", "Order ID", "Customer Name", "Order Date", "Status");
        for (Queue queue : new Queue[]{validatedOrdersQueue, unvalidatedOrdersQueue}) {
            Queue tempQueue = new Queue();
            while (!queue.isEmpty()) {
                Order order = (Order) queue.dequeue();
                tempQueue.enqueue(order);
                System.out.printf("%-10d %-20s %-15s %-20s\n", order.getId(), order.getUsername(), order.getOrderDate(), order.getStatus());
            }
            // Restore queue
            while (!tempQueue.isEmpty()) {
                queue.enqueue(tempQueue.dequeue());
            }
        }
        System.out.println("--------------------------");
        System.out.print("Enter Order ID to delete (00 to Cancel): ");
        int orderId = s.nextInt();
            if (orderId == 00){
                System.out.println("Cancelling....");
                return;
            }
    
        for (Queue queue : new Queue[]{validatedOrdersQueue, unvalidatedOrdersQueue}) {
            Queue tempQueue = new Queue();
            while (!queue.isEmpty()) {
                Order order = (Order) queue.dequeue();
                if (order.getId() == orderId) {
                    Account customer = getUserByUsername(order.getUsername());
                    if (customer != null && customer instanceof Customer) {
                        ((Customer) customer).removeOrder(order);
                    }
                    System.out.println("Order deleted.");
                    found = true;
                } else {
                    tempQueue.enqueue(order);
                }
            }
            // Restore orders
            while (!tempQueue.isEmpty()) {
                queue.enqueue(tempQueue.dequeue());
            }
        }
    
        if (!found) {
            System.out.println("Order ID not found.");
        } else {
            saveOrdersToFile();
            saveUnvalidatedOrdersToFile();
        }
    } 
    

    private void manageItems() {
        Scanner s = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nManage Items");
            System.out.println("1. View Items");
            System.out.println("2. Add New Item");
            System.out.println("3. Edit Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Back to menu");
            System.out.print("Pilih: ");
            String choice = s.next()+s.nextLine();
    
            switch (choice) {
                case "1":
                    viewItems();
                    break;
                case "2":
                    addItem();
                    break;
                case "3":
                    editItem();
                    break;
                case "4":
                    deleteItem();
                    break;
                case "5":
                    adminMenu();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void viewItems() {
        System.out.println("\nList of Items:");
        for (Items item : itemsList) {
            System.out.println("ID: " + item.getItemID() + " | Brand: " + item.getBrand() + " | Name: " + item.getName() + " | Status: " + item.getStatus());
        }
        System.out.print("Enter ID to view details or '00' to return: ");
        Scanner s = new Scanner(System.in);
        String input = s.next()+s.nextLine();
        if (!"00".equalsIgnoreCase(input)) {
            viewItemDetails(input);
        }
    }
    
    private void viewItemDetails(String itemId) {
        Items item = getItemById(itemId);
        if (item != null) {
            System.out.println("\nItem Details:");
            System.out.println("ID: " + item.getItemID());
            System.out.println("Brand: " + item.getBrand());
            System.out.println("Name: " + item.getName());
            System.out.println("Scale: " + item.getScale());
            System.out.println("Description: " + item.getDescription());
            System.out.println("Price: Rp. " + item.getPrice());
            System.out.println("DP Price: Rp." + item.getDp_price());
            System.out.println("Max PO Date: " + item.getMaxPODate());
            System.out.println("Estimated Time of Arrival: " + item.getEstimatedTimeOfArrival());
            System.out.println("Slots: " + item.getSlots());
            System.out.println("Status: " + item.getStatus());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Item not found. Please check the ID and try again.");
        }
    }
    
    private void addItem() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nAdding New Item:");
        System.out.print("ID: ");
        String id = s.next()+s.nextLine();
        System.out.print("Brand: ");
        String brand = s.next()+s.nextLine();
        System.out.print("Name: ");
        String name = s.next()+s.nextLine();
        System.out.print("Scale: ");
        String scale = s.next()+s.nextLine();
        System.out.print("Description: ");
        String description = s.next()+s.nextLine();
        System.out.print("Price: ");
        double price = s.nextDouble();
        System.out.print("DP Price: ");
        double dpPrice = s.nextDouble();
            while (dpPrice > price){
                System.out.println("Down Payment (DP) cannot be bigger than Overall Price!");
                System.out.print("Price: ");
                price = s.nextDouble();
                System.out.print("DP Price: ");
                dpPrice = s.nextDouble();
            }
        System.out.print("Max PO Date: ");
        String maxPoDate = s.next()+s.nextLine();
        System.out.print("Estimated Time of Arrival: ");
        String eta = s.next()+s.nextLine();
        System.out.print("Slots: ");
        int slots = s.nextInt();
            if (slots < 0){
                System.out.println("Slots for item cannot be smaller than 0");
                System.out.print("Slots: ");
                slots = s.nextInt();
            }
        System.out.print("Status (1. Open/2. Closed): ");
        String status = s.next()+s.nextLine();
            while (!status.equals("1") && !status.equals("2") ){
                System.out.println("Can only choose 1 (Open) or 2 (Closed)");
                System.out.print("Status (1. Open/2. Closed): ");
                status = s.next()+s.nextLine();
            }
        if (status.equals("1")){
            status = "open";
        } else if (status.equals("2")){
            status = "closed";
        }
        Items newItem = new Items(id, brand, name, scale, description, price, dpPrice, maxPoDate, eta, slots, status);
        itemsList.add(newItem);
        saveItemsToFile();
        System.out.println("Item added successfully!");
    }
    
    private void editItem() {
        System.out.println("\nEditing Item:");
        for (Items item : itemsList) {
            System.out.println("ID: " + item.getItemID() + " | Brand: " + item.getBrand() + " | Name: " + item.getName() + " | Status: " + item.getStatus());
        }
        Scanner s = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.print("Enter the ID of the item to edit (00 to Cancel): ");
        String itemId = s.next()+s.nextLine();
            if (itemId.equals("00")){
                System.out.println("Cancelling....");
                manageItems();
            }
        boolean found = false;
        for (Items item : itemsList) {
            if (item.getItemID().equals(itemId)) {
                System.out.println("\nOld Details: ");
                System.out.println("ID: " + item.getItemID());
                System.out.println("Brand: " + item.getBrand());
                System.out.println("Name: " + item.getName());
                System.out.println("Scale: " + item.getScale());
                System.out.println("Description: " + item.getDescription());
                System.out.println("Price: Rp. " + item.getPrice());
                System.out.println("DP Price: Rp. " + item.getDp_price());
                System.out.println("Max PO Date: " + item.getMaxPODate());
                System.out.println("Estimated Time of Arrival: " + item.getEstimatedTimeOfArrival());
                System.out.println("Slots: " + item.getSlots());
                System.out.println("Status: " + item.getStatus());
                System.out.println("-----------------------------");
                System.out.println("Enter the new details (leave blank to keep current):");
                System.out.print("Brand (" + item.getBrand() + "): ");
                String brand = s.nextLine();
                if (!brand.isEmpty()) item.setBrand(brand);

                System.out.print("Name (" + item.getName() + "): ");
                String name = s.nextLine();
                if (!name.isEmpty()) item.setName(name);
                
                System.out.print("Scale (" + item.getScale() + "): ");
                String scale = s.nextLine();
                if (!scale.isEmpty()) item.setScale(scale);
                
                System.out.print("Description (" + item.getDescription() + "): ");
                String description = s.nextLine();
                if (!description.isEmpty()) item.setDescription(description);
                
                System.out.print("Price (" + item.getPrice() + "): ");
                String price = s.nextLine();
                if (!price.isEmpty()) item.setPrice(Double.parseDouble(price));
                
                System.out.print("DP Price (" + item.getDp_price() + "): ");
                String dpPrice = s.nextLine();
                if (!dpPrice.isEmpty()) item.setDp_price(Double.parseDouble(dpPrice));
                
                System.out.print("Max PO Date (" + item.getMaxPODate() + "): ");
                String maxPoDate = s.nextLine();
                if (!maxPoDate.isEmpty()) item.setMaxPoDate(maxPoDate);
                
                System.out.print("Estimated Time of Arrival (" + item.getEstimatedTimeOfArrival() + "): ");
                String eta = s.nextLine();
                if (!eta.isEmpty()) item.setEstimatedTimeOfArrival(eta);
                
                System.out.print("Slots (" + item.getSlots() + "): ");
                String slots = s.nextLine();
                if (!slots.isEmpty()) item.setSlots(Integer.parseInt(slots));
                
                System.out.print("Status (" + item.getStatus() + ") (1. Open/2. Closed/3. Keep Current): ");
                String status = s.nextLine();
                if (!status.isEmpty()) {
                switch (status) {
                    case "1":
                        item.setStatus("open");
                        break;
                    case "2":
                        item.setStatus("closed");
                        break;
                    case "3":
                        //keep current
                        break;
                    default:
                        System.out.println("Invalid status input. Keeping current status.");
                        break;
                    }
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found!");
        } else {
            saveItemsToFile();
            System.out.println("Item edited successfully!");
        }
    }
    
    private void deleteItem() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nDeleting Item:");
        for (Items item : itemsList) {
            System.out.println("ID: " + item.getItemID() + " | Brand: " + item.getBrand() + " | Name: " + item.getName() + " | Status: " + item.getStatus());
        }
        System.out.println("--------------------");
        System.out.print("Enter the ID of the item to delete (00 to Cancel): ");
        String itemID = s.next()+s.nextLine();
            if (itemID.equals("00")){
                System.out.println("Cancelling....");
                manageItems();
            }
        boolean found = false;
        for (Iterator<Items> iterator = itemsList.iterator(); iterator.hasNext(); ) {
            Items item = iterator.next();
            if (item.getItemID().equals(itemID)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found!");
        } else {
            saveItemsToFile();
            System.out.println("Item deleted successfully!");
        }
    }

    private void viewCustomerOrderStatistics() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nCustomer Order Statistics:");
        for (Account acc : userlist) {
            if (acc instanceof Customer) {
                Customer customer = (Customer) acc;
                System.out.println("Username: " + customer.getusername());
                System.out.println("Address: " + customer.getaddress());
                System.out.println("Total Orders: " + customer.getTotalOrdersCount());
                System.out.println("Total Amount Spent: Rp. " + customer.getTotalAmountSpent());
                System.out.println("-----------------------------");
            }
        }
        // resetCustomerOrders(); (for debugging)
    }

    private Account getUserByUsername(String username) {
        for (Account acc : userlist) {
            if (acc.getusername().equals(username)) {
                return acc;
            }
        }
        return null;
    }

    private void resetCustomerOrders() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the username of the customer to reset orders: ");
        String username = s.next();
        Account customer = getUserByUsername(username);

        if (customer != null && customer instanceof Customer) {
            ((Customer) customer).resetOrders();
            saveUsersToFile(); // Save changes
            System.out.println("Orders for customer " + username + " have been reset.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void setBankAccountDetails() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Bank Name: ");
        bankName = s.nextLine();
        System.out.print("Enter Bank Account Number: ");
        bankAccountNumber = s.nextLine();
        saveBankDetailsToFile();
        System.out.println("Bank account details set successfully.");
    }

    private void editBankAccountDetails() {
        Scanner s = new Scanner(System.in);
        
        System.out.println("\nCurrent Bank Account Details:");
        System.out.println("Bank Name: " + (bankName != null ? bankName : "Not set"));
        System.out.println("Bank Account Number: " + (bankAccountNumber != null ? bankAccountNumber : "Not set"));
        
        System.out.println("\nEnter new details (leave blank to keep current):");
        
        System.out.print("Enter Bank Name (" + (bankName != null ? bankName : "Not set") + "): ");
        String newBankName = s.nextLine();
        if (!newBankName.isEmpty()) {
            bankName = newBankName;
        }
        
        System.out.print("Enter Bank Account Number (" + (bankAccountNumber != null ? bankAccountNumber : "Not set") + "): ");
        String newBankAccountNumber = s.nextLine();
        if (!newBankAccountNumber.isEmpty()) {
            bankAccountNumber = newBankAccountNumber;
        }
        
        saveBankDetailsToFile();
        System.out.println("Bank account details updated successfully.");
    }
    
    private void editUserInfo() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nProfile Information:");
        System.out.println("Username: " + user.getusername());
        System.out.println("Address: " + user.getaddress());
        System.out.println("\nEdit Information:");
        System.out.println("1. Edit Username");
        System.out.println("2. Edit Password");
        System.out.println("3. Edit Address");
        System.out.println("4. Cancel");
        System.out.print("Input: ");
        String choice = s.next()+s.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Input new username: ");
                String newUsername = s.next() + s.nextLine();
                user.setusername(newUsername);
                saveUsersToFile();
                System.out.println("Username updated.");
                break;
            case "2":
                System.out.print("Input Password: ");
                String currentPassword = s.next() + s.nextLine();
                if (currentPassword.equals(user.getpassword())) {
                    System.out.print("Input new Password: ");
                    String newPassword = s.next();
                    user.setpassword(newPassword);
                    saveUsersToFile();
                    System.out.println("Password updated.");
                } else {
                    System.out.println("Incorrect password. Edit cancelled.");
                }
                break;
            case "3":
            System.out.print("Input Password: ");
            currentPassword = s.next() + s.nextLine();
            if (currentPassword.equals(user.getpassword())) {
                System.out.println("Format for Address: Road Name/Number, Ward (Kelurahan), City/County (Kota/Kabupaten), Post Code");
                System.out.println("Example: Jalan Pantai Berhari 10, Gayungan, Surabaya, 60123");
                System.out.print("Input new Address: ");
                String newAddress = s.nextLine();
                user.setaddress(newAddress);
                saveUsersToFile();
                System.out.println("Address updated.");
            } else {
                System.out.println("Incorrect password. Edit cancelled.");
            }
            break;
            case "4":
            System.out.println("Edit cancelled.");
            break;

            default:
                System.out.println("Invalid input.");
        }
    }
    
    public void menu() {
        //program starts here
        Scanner s = new Scanner(System.in);
        Account currentuser = null;
        while (currentuser == null) {
            System.out.println("\n---------------------------------");
            System.out.println("Welcome to Placeholder Diecast!");
            System.out.println("---------------------------------");
            System.out.println("1. Login");
            System.out.println("2. Register New Account");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            String choose = s.next()+s.nextLine();
                while (!choose.equals("1") && !choose.equals("2") && !choose.equals("3")){
                    System.out.print("Invalid Input! Choose: ");
                    choose = s.next()+s.nextLine();
                }
            if (choose.equals("1")) {
                currentuser = login();
            } else if (choose.equals("2")) {
                currentuser = register();
            } else if (choose.equals("3")) {
                saveUsersToFile();
                saveOrdersToFile();
                saveCartsToFile();
                saveItemsToFile();
                System.exit(0);
            }
            if (currentuser != null) {
                System.out.println("Hello, " + currentuser.getusername() + "!");
                this.user = currentuser;
                gotomenu();
            }
        }
    }

    public Account login() {
        String tryagain = "";
        while (!tryagain.equalsIgnoreCase("n")) {
            Scanner s = new Scanner(System.in);
            System.out.println("\n\n=== Login ===");
            System.out.print("Username: ");
            String uname = s.next()+s.nextLine();
            System.out.print("Password: ");
            String pwd = s.next()+s.nextLine();

            for (Account acc : userlist) {
                if (acc.getusername().equals(uname) && acc.getpassword().equals(pwd)) {
                    System.out.println("Login successful!");
                    return acc;
                }
            }
            // Account not found/wrong
            System.out.println("Incorrect Username or Password!");
            System.out.print("Try Again (Y/N)? :  ");
            tryagain = s.next()+s.nextLine();
            while (!tryagain.equalsIgnoreCase("y") && !tryagain.equalsIgnoreCase("n")){
                System.out.print("Invalid Input (Only Y/N). Try Again? : ");
                tryagain = s.next()+s.nextLine();
            }
        }
        return null;
    }

    public Account register() {
        Scanner s = new Scanner(System.in);
        System.out.println("\n\n=== Registration ===");
        
        String uname;
        while (true) {
            System.out.print("Username: ");
            uname = s.next();
            if (isUsernameTaken(uname)) {
                System.out.println("Username already taken. Please choose another.");
            } else {
                break;
            }
        }
        
        System.out.print("Password: ");
        String pwd = s.next();
        System.out.print("Account Type (1. admin/2. customer): ");
        String type = s.next() + s.nextLine();
    
        Account u;
        if (type.equalsIgnoreCase("1")) {
            System.out.print("Enter secret code: ");
            String secretCode = s.next();
            if (!secretCode.equals("admin1234567890")) {
                System.out.println("Incorrect secret code, returning to menu.........");
                return null;
            }
            u = new Admin();
            u.setusername(uname);
            u.setpassword(pwd);
        } else {
            u = new Customer();
            u.setusername(uname);
            u.setpassword(pwd);
            System.out.println("Format for Address: Road Name/Number, Ward (Kelurahan), City/County (Kota/Kabupaten), Post Code");
            System.out.println("Contoh: Jalan Pantai Berhari 10, Gayungan, Surabaya, 60123");
            System.out.print("Input Address: ");
            String address = s.next() + s.nextLine();
            u.setaddress(address);
        }
    
        System.out.println("New user has been successfully registered!");
        userlist.add(u);
        saveUsersToFile();
        return u;
    }

    private boolean isUsernameTaken(String username) {
        for (Account acc : userlist) {
            if (acc.getusername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void loadUsersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE_NAME))) {
            userlist = (ArrayList<Account>) ois.readObject();
        } catch (FileNotFoundException e) {
            // System.out.println("No user data found, starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveUsersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE_NAME))) {
            oos.writeObject(userlist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveItemsToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ITEMS_FILE_NAME))) {
            outputStream.writeObject(itemsList);
            // System.out.println("Items saved to file successfully.");
        } catch (IOException e) {
            // System.out.println("Error saving items to file: " + e.getMessage());
        }
    }

    private void loadItemsFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ITEMS_FILE_NAME))) {
            itemsList = (LinkedList<Items>) inputStream.readObject();
            // System.out.println("Items loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            // System.out.println("Error loading items from file: " + e.getMessage());
        }
    }

    private void saveOrdersToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ORDERS_FILE_NAME))) {
            // convert queue to arraylist for serliazing
            ArrayList<Order> ordersList = new ArrayList<>();
            Queue tempQueue = new Queue();
            
            // Dequeue each order from the validated queue, add to list and re-enqueue to the queue
            while (!validatedOrdersQueue.isEmpty()) {
                Order order = (Order) validatedOrdersQueue.dequeue();
                ordersList.add(order);
                tempQueue.enqueue(order);
            }
            
            // Restore the validated queue
            while (!tempQueue.isEmpty()) {
                validatedOrdersQueue.enqueue(tempQueue.dequeue());
            }
            
            outputStream.writeObject(ordersList);
            // System.out.println("Orders saved to file successfully.");
        } catch (IOException e) {
            // System.out.println("Error saving orders to file: " + e.getMessage());
        }
    }

    private void loadOrdersFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ORDERS_FILE_NAME))) {
            ArrayList<Order> ordersList = (ArrayList<Order>) inputStream.readObject();
            for (Order order : ordersList) {
                validatedOrdersQueue.enqueue(order);
                Account customer = getUserByUsername(order.getUsername());
                if (customer != null && customer instanceof Customer) {
                    ((Customer) customer).resetOrders(); // Clear existing orders before adding new ones
                    ((Customer) customer).addOrder(order);
                }
            }
            // System.out.println("Validated orders loaded from file successfully.");
        } catch (FileNotFoundException e) {
            // System.out.println("No validated orders data found, starting with an empty queue.");
        } catch (IOException | ClassNotFoundException e) {
            // System.out.println("Error loading validated orders from file: " + e.getMessage());
        }
    }

    private void saveUnvalidatedOrdersToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(UNVALIDATED_ORDERS_FILE_NAME))) {
            ArrayList<Order> ordersList = new ArrayList<>();
            Queue tempQueue = new Queue();
            
            // Dequeue each order from the unvalidated queue, add to list and re-enqueue to the queue
            while (!unvalidatedOrdersQueue.isEmpty()) {
                Order order = (Order) unvalidatedOrdersQueue.dequeue();
                ordersList.add(order);
                tempQueue.enqueue(order);
            }
            
            // Restore unvalidated queue
            while (!tempQueue.isEmpty()) {
                unvalidatedOrdersQueue.enqueue(tempQueue.dequeue());
            }
            
            outputStream.writeObject(ordersList);
            // System.out.println("Unvalidated orders saved to file successfully.");
        } catch (IOException e) {
            // System.out.println("Error saving unvalidated orders to file: " + e.getMessage());
        }
    }

    private void loadUnvalidatedOrdersFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(UNVALIDATED_ORDERS_FILE_NAME))) {
            ArrayList<Order> ordersList = (ArrayList<Order>) inputStream.readObject();
            for (Order order : ordersList) {
                unvalidatedOrdersQueue.enqueue(order);
            }
            // System.out.println("Unvalidated orders loaded from file successfully.");
        } catch (FileNotFoundException e) {
            // System.out.println("No unvalidated orders data found, starting with an empty queue.");
        } catch (IOException | ClassNotFoundException e) {
            // System.out.println("Error loading unvalidated orders from file: " + e.getMessage());
        }
    }    

    private void loadCartsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CART_FILE_NAME))) {
            cartList = (ArrayList<Cart>) ois.readObject();
            // System.out.println("Carts loaded from file successfully.");
        } catch (FileNotFoundException e) {
            // System.out.println("No cart data found, starting with an empty cart list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void saveCartsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CART_FILE_NAME))) {
            oos.writeObject(cartList);
            // System.out.println("Carts saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void loadUserCart() {
        boolean cartLoaded = false;
        for (Cart savedCart : cartList) {
            if (savedCart.getcUsername().equals(user.getusername())) {
                cart = savedCart;
                cart.setMenu(this);
                cartLoaded = true;
                break;
            }
        }
        if (!cartLoaded) {
            cart = new Cart(this);
            cart.setcUsername(user.getusername());
        }
    }

    private void saveUserCart() {
        // Remove existing cart for the current user
        cartList.removeIf(c -> c.getcUsername().equals(user.getusername()));
        // Add the current user's cart
        cartList.add(cart);
        saveCartsToFile();
    }

    private void loadBankDetailsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BANK_DETAILS_FILE_NAME))) {
            String[] bankDetails = (String[]) ois.readObject();
            if (bankDetails.length == 2) {
                bankName = bankDetails[0];
                bankAccountNumber = bankDetails[1];
            }
            // System.out.println("Bank details loaded from file successfully.");
        } catch (FileNotFoundException e) {
            // System.out.println("No bank details found, starting with empty details.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveBankDetailsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BANK_DETAILS_FILE_NAME))) {
            String[] bankDetails = { bankName, bankAccountNumber };
            oos.writeObject(bankDetails);
            // System.out.println("Bank details saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}