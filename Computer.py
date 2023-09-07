class Computer:
    def __init__(self, brand, model, processor, ram, storage, operating_system, price):
        self.brand = brand
        self.model = model
        self.processor = processor
        self.ram = ram
        self.storage = storage
        self.operating_system = operating_system
        self.price = price

    def start(self):
        print("Computer started.")

    def shutdown(self):
        print("Computer shut down.")

    def restart(self):
        print("Computer restarted.")

    def sleep(self):
        print("Computer went to sleep.")

    def upgrade_ram(self, additional_ram):
        self.ram += additional_ram
        print(f"RAM upgraded to {self.ram}GB.")

    def upgrade_storage(self, new_storage):
        self.storage = new_storage
        print(f"Storage upgraded to {self.storage}.")

    def install_software(self, software_name):
        print(f"Installed {software_name} software.")

    def run_application(self, app_name):
        print(f"Running {app_name}.")

    def check_status(self):
        print("Computer Status:")
        print(f"Brand: {self.brand}")
        print(f"Model: {self.model}")
        print(f"Processor: {self.processor}")
        print(f"RAM: {self.ram}GB")
        print(f"Storage: {self.storage}")
        print(f"Operating System: {self.operating_system}")
        print(f"Price: ${self.price}")