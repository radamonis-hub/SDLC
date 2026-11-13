package CaterFlowModel {

    part def CaterFlowSystem;
    part def GuestCustomer;
    part def RegisteredCustomer;
    part def Manager;
    part def Administrator;

    use case def BrowseCatalog {
        subject system : CaterFlowSystem;
        actor customer : GuestCustomer;
        actor registeredCustomer : RegisteredCustomer;
        objective { doc /* Просмотр доступных блюд и готовых предложений. */ }
        action viewCategories;
        action viewDishes;
    }

    use case def SearchDishes {
        subject system : CaterFlowSystem;
        actor customer : GuestCustomer;
        actor registeredCustomer : RegisteredCustomer;
        objective { doc /* Поиск блюд по названию. */ }
        action enterSearchQuery;
        action displaySearchResults;
    }

    use case def BuildMenu {
        subject system : CaterFlowSystem;
        actor customer : GuestCustomer;
        actor registeredCustomer : RegisteredCustomer;
        objective { doc /* Формирование индивидуального меню мероприятия. */ }
        action selectDishes;
        action specifyGuestCount;
        action calculateMenuCost;
    }

    use case def SubmitOrder {
        subject system : CaterFlowSystem;
        actor customer : GuestCustomer;
        actor registeredCustomer : RegisteredCustomer;
        objective { doc /* Отправка заявки на организацию кейтеринга. */ }
        action enterCustomerDetails;
        action submitApplication;
    }

    use case def ViewOrderHistory {
        subject system : CaterFlowSystem;
        actor customer : RegisteredCustomer;
        objective { doc /* Просмотр ранее оформленных заказов. */ }
        action requestOrderHistory;
        action displayOrders;
    }

    use case def SaveMenu {
        subject system : CaterFlowSystem;
        actor customer : RegisteredCustomer;
        objective { doc /* Сохранение выбранного варианта меню. */ }
        action saveMenuConfiguration;
    }

    use case def EmployeeAuthorization {
        subject system : CaterFlowSystem;
        actor manager : Manager;
        actor administrator : Administrator;
        objective { doc /* Вход менеджера или администратора в служебную часть приложения. */ }
        action enterCredentials;
        action verifyCredentials;
    }

    use case def ProcessOrders {
        subject system : CaterFlowSystem;
        actor employee : Manager;
        objective { doc /* Обработка поступивших заявок клиентов. */ }
        action viewApplications;
        action updateOrderStatus;
        action editOrder;
    }

    use case def ManageCatalog {
        subject system : CaterFlowSystem;
        actor employee : Administrator;
        objective { doc /* Управление каталогом блюд и категорий. */ }
        action manageDishes;
        action manageCategories;
        action updatePrices;
    }

    use case def ManageSets {
        subject system : CaterFlowSystem;
        actor employee : Administrator;
        objective { doc /* Управление готовыми предложениями. */ }
        action createSet;
        action editSet;
        action deactivateDishes;
    }
    

}