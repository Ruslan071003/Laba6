package com.example.myfriendofmisery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Button calculateButton;
    private Button clearAllButton;
    private ArrayList<Order> orders;
    private ArrayAdapter<Order> adapter;
    private CheckBox carCheckBox;
    private CheckBox docCheckBox;

    private TextView courierInfoTextView;

    private ArrayList<Order> filteredOrders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courierInfoTextView = findViewById(R.id.courierInfoTextView);
        docCheckBox = findViewById(R.id.docCheckBox);
        carCheckBox = findViewById(R.id.carCheckBox);
        filteredOrders = new ArrayList<>();

        listView = findViewById(R.id.listView);
        orders = new ArrayList<>();
        adapter = new OrderAdapter(this, R.layout.order_item, orders);
        listView.setAdapter(adapter);


        populateOrders();

        filterOrders();
        calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalCost();
            }
        });

        clearAllButton = findViewById(R.id.clearAllButton);
        clearAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllCheckBoxes();
            }
        });

        Curer courier = new Curer("Асимов Фирдавсхон Хуршедович", "1123 5813  2134", true, true);
        String courierInfo = "ФИО: " + courier.getFullName() + "\n"
                + "Карта: " + courier.getCurrentAccount();

        courierInfoTextView.setText(courierInfo);

        carCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                filterOrders();
            }
        });

        docCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                filterOrders();
            }
        });


    }


    private void populateOrders() {

        Calendar calendar = Calendar.getInstance();


        calendar.set(2023, Calendar.NOVEMBER, 15);
        Date expirationDate1 = calendar.getTime();

        calendar.set(2023, Calendar.SEPTEMBER, 18);
        Date expirationDate2 = calendar.getTime();

        calendar.set(2023, Calendar.NOVEMBER, 18);
        Date expirationDate3 = calendar.getTime();

        calendar.set(2023, Calendar.DECEMBER, 20);
        Date expirationDate4 = calendar.getTime();

        calendar.set(2023, Calendar.DECEMBER, 9);
        Date expirationDate5 = calendar.getTime();

        calendar.set(2023, Calendar.SEPTEMBER, 13);
        Date expirationDate6 = calendar.getTime();

        calendar.set(2023, Calendar.NOVEMBER, 25);
        Date expirationDate7 = calendar.getTime();




        // Create orders with the updated expiration dates
        orders.add(new Order(new Firm("ООО Шахтер"), new Mini(), "ул. Шахтерская 5", "Истринская д.8.3", 1000, expirationDate1));

        orders.add(new Order(new Firm("ООО Малан"), new Mini(),"ул Маланьина 5", "ул Маланьина 7", 2000, expirationDate7));

        orders.add(new Order(new Firm("ООО Нефтянник"), new Big(5.0), "ул. Нефтянника 10", "Истринская д.8.3", 2000, expirationDate2));

        orders.add(new Order(new Firm("ООО Береза"), new Document("Sender", "ул. Березовая  15"), "Истринская д.8.3", "Истринская д.8.3", 1000, expirationDate3));

        orders.add(new Order(new Firm("ООО Сириус"), new Document("Кременчугская ул", "Большая Очаковская"),"Большая Очаквоская д 7", "Давыдковская ул",3000, expirationDate4));

        orders.add(new Order(new Firm("ООО Базис"), new Document("Измайлосвкая 9", "Измайловская 4"), "Академика-Янгеля", "Веерная ул", 2500, expirationDate5));

        orders.add(new Order(new Firm("ООО МосГаз"),new Big(7.0), "ул Каштаянца", "Ул Андрея Свиридова", 2000, expirationDate6));

        adapter.notifyDataSetChanged();
    }

    private void calculateTotalCost() {
        double totalCost = 0.0;


        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            View view = listView.getChildAt(i);

            if (view != null) {
                CheckBox checkBox = view.findViewById(R.id.checkbox);
                if (checkBox != null) {
                    if (checkBox.isChecked()) {
                        totalCost += order.getPrice();
                    }
                }
            }
        }


        Toast.makeText(this, "Полученно: " + totalCost + " Р", Toast.LENGTH_SHORT).show();}
    private void clearAllCheckBoxes() {
        for (int i = 0; i < listView.getChildCount(); i++) {
            View view = listView.getChildAt(i);
            CheckBox checkBox = view.findViewById(R.id.checkbox);
            if (checkBox != null) {
                checkBox.setChecked(false);
            }
        }
    }

    private void filterOrders() {
        boolean showCarOrders = carCheckBox.isChecked();
        boolean showDocOrders = docCheckBox.isChecked();

        filteredOrders.clear();

        long currentTime = System.currentTimeMillis();

        for (Order order : orders) {

            if (order.getExpirationDate() > currentTime &&
                    ((showCarOrders && (order.getPackage() instanceof Big || order.getPackage() instanceof Mini))
                            || (showDocOrders && (order.getPackage() instanceof Document || order.getPackage() instanceof Mini))
                            || (showCarOrders && showDocOrders) || order.getPackage() instanceof Mini)) {
                filteredOrders.add(order);
            }
        }

        OrderAdapter filteredAdapter = new OrderAdapter(this, R.layout.order_item, filteredOrders);
        listView.setAdapter(filteredAdapter);
    }
}


