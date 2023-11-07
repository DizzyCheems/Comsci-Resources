class Customer:
    def __init__(self, name, address, telephone_number):
        self.name = name
        self.address = address
        self.telephone_number = telephone_number

    def get_name(self):
        return self.name

    def get_address(self):
        return self.address

    def get_telephone_number(self):
        return self.telephone_number

    def set_name(self, name):
        self.name = name

    def set_address(self, address):
        self.address = address

    def set_telephone_number(self, telephone_number):
        self.telephone_number = telephone_number

class Car:
    def __init__(self, make, model, year):
        self.make = make
        self.model = model
        self.year = year

    def get_make(self):
        return self.make

    def get_model(self):
        return self.model

    def get_year(self):
        return self.year

    def set_make(self, make):
        self.make = make

    def set_model(self, model):
        self.model = model

    def set_year(self, year):
        self.year = year

class ServiceQuote:
    def __init__(self, parts_charges, labor_charges):
        self.parts_charges = parts_charges
        self.labor_charges = labor_charges
        self.sales_tax = 0.05  

    def get_parts_charges(self):
        return self.parts_charges

    def get_labor_charges(self):
        return self.labor_charges

    def get_sales_tax(self):
        return self.sales_tax

    def set_parts_charges(self, parts_charges):
        self.parts_charges = parts_charges

    def set_labor_charges(self, labor_charges):
        self.labor_charges = labor_charges

    def set_total_charges(self):
        total_charges = self.parts_charges + self.labor_charges + (self.parts_charges * self.sales_tax)
        return total_charges


num_customers = int(input("Enter number of customers: "))

customers = []

for i in range(1, num_customers + 1):
    print(f"CUSTOMER {i}")
    print("Personal details")
    print("----------------------")
    name = input("Enter name: ")
    address = input("address: ")
    tel_number = input("tel.no: ")
    customer = Customer(name, address, tel_number)

    print("----------------------")
    print("Car details")
    print("----------------------")
    make = input("make: ")
    model = input("model: ")
    year = int(input("year: "))
    car = Car(make, model, year)

    print("----------------------")
    print("Service Quote:")
    print("___________________")
    parts_charge = float(input("parts charge: "))
    labor_charge = float(input("labor charge: "))
    service_quote = ServiceQuote(parts_charge, labor_charge)


    customers.append((customer, car, service_quote))


for i, (customer, car, service_quote) in enumerate(customers, 1):
    print(f"\nCUSTOMER {i}")
    print("Personal details")
    print("----------------------")
    print("name:", customer.get_name())
    print("address:", customer.get_address())
    print("tel.no:", customer.get_telephone_number())

    print("----------------------")
    print("Car details")
    print("----------------------")
    print("make:", car.get_make())
    print("model:", car.get_model())
    print("year:", car.get_year())

    print("----------------------")
    print("Service Quote:")
    print("___________________")
    print("parts charge:", service_quote.get_parts_charges())
    print("labor charge:", service_quote.get_labor_charges())