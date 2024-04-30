package com.example.myecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Products extends AppCompatActivity {
    private EditText searchBar;
    private RecyclerView recyclerViewProducts;
    private ArrayList<Items> products;
    private ArrayList<Items> filteredList;
    private ProductsAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        searchBar = findViewById(R.id.searchBar);
        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);

        // Initialize the lists
        products = new ArrayList<>();
        filteredList = new ArrayList<>();
        //tyagi

//        products.add(new Items("Dress Shoes", "https://images.pexels.com/photos/786003/pexels-photo-786003.jpeg", 917));
//        products.add(new Items("Running Shoes", "https://images.pexels.com/photos/292999/pexels-photo-292999.jpeg", 987));
//        products.add(new Items("Walking Sneakers", "https://images.pexels.com/photos/267301/pexels-photo-267301.jpeg", 557));
//        products.add(new Items("Athletic Sneakers", "https://images.pexels.com/photos/19090/pexels-photo.jpg", 864));
//        products.add(new Items("Walking Sneakers", "https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1696624040-813PcM656QL.jpg", 690));
//        products.add(new Items("Dress Shoes", "https://contents.mediadecathlon.com/p2393859/29b8b8eee38946900910e3616879676b/p2393859.jpg", 990));
//        products.add(new Items("Running Shoes", "https://hips.hearstapps.com/hmg-prod/images/hoka-zinal-13085-1643565794.jpg", 664));
//        products.add(new Items("Casual Loafers", "https://hips.hearstapps.com/hmg-prod/images/cushioned-shoes-15407-1632754173.jpg", 771));
//        products.add(new Items("Hiking Boots", "https://hips.hearstapps.com/hmg-prod/images/mens-shoes-new-lead-1658513429.jpg", 999));
//        products.add(new Items("Running Shoes", "https://c02.purpledshub.com/uploads/sites/39/2024/02/AM9A1785-scaled.jpg", 954));
//        products.add(new Items("Walking Sneakers", "https://s3.us-east-1.amazonaws.com/images.gearjunkie.com/uploads/2023/06/CamHanesCrop-scaled.jpg", 617));
//        products.add(new Items("Hiking Boots", "https://www.birkenstock.com/dw/image/v2/BDXC_PRD/on/demandware.static/-/Sites-master-catalog/default/dwa6227bdb/1024633/1024633.jpg", 924));
//        products.add(new Items("Athletic Sneakers", "https://www.newbalance.com/dw/image/v2/AAGI_PRD/on/demandware.static/-/Library-Sites-NBUS-NBCA/default/dw5516e793/images/page-designer/2024/March/16222_Comp_A2_Mobile.jpg", 901));
//        products.add(new Items("Dress Shoes", "https://www.newtonrunning.com/cdn/shop/files/NR-GMD13-Web-Header-All-2.jpg", 850));
//        products.add(new Items("Running Shoes", "https://www.newtonrunning.com/cdn/shop/files/NR-Fusion2-Web-Header.jpg", 618));
//        products.add(new Items("Running Shoes", "https://runkeeper.com/cms/wp-content/uploads/sites/4/2021/12/ASICS_Color-Injection-Pack_Highlight_0253-scaled.jpg", 893));
//        products.add(new Items("Walking Sneakers", "https://cdn.thewirecutter.com/wp-content/media/2023/05/running-shoes-2048px-9718.jpg", 799));
//        products.add(new Items("Dress Shoes", "https://cdn.thewirecutter.com/wp-content/media/2023/09/running-shoes-2048px-5946.jpg", 682));
//        products.add(new Items("Athletic Sneakers", "http://media.gq.com/photos/63eba1b2275d2fef78a425c2/master/pass/nike-running-shoes-streakfly-invincible.jpg", 854));
//        products.add(new Items("Hiking Boots", "http://media.gq.com/photos/646fdd946cbe43aa644cd88b/master/pass/shoes-art.jpg", 811));
//        products.add(new Items("Dress Shoes", "https://www.rollingstone.com/wp-content/uploads/2023/01/best-gym-shoes.jpg", 561));
//        products.add(new Items("Dress Shoes", "https://cdn.thewirecutter.com/wp-content/media/2021/10/running-shoes-2048px-3128-2x1-1.jpg", 879));
//        products.add(new Items("Running Shoes", "https://cdn.mos.cms.futurecdn.net/FdVriqcnyu9FCWcbwYmKAJ.jpg", 692));
//        products.add(new Items("Hiking Boots", "https://hips.hearstapps.com/hmg-prod/images/run-nike-running-shoes-646cdd1a19c41.jpg", 722));
//        products.add(new Items("Hiking Boots", "https://hips.hearstapps.com/hmg-prod/images/gh-best-walking-shoe-65cb95a510cbd.png", 897));
//        products.add(new Items("Casual Loafers", "https://hips.hearstapps.com/hmg-prod/images/index-1580510677.jpg", 714));
//        products.add(new Items("Running Shoes", "https://www.shutterstock.com/shutterstock/photos/92008067/display_1500/stock-photo-vintage-red-shoes-on-white-background-92008067.jpg", 617));
//        products.add(new Items("Athletic Sneakers", "https://www.fluevog.com/wp-content/uploads/2024/04/Strozzi-purple_slider.jpg", 624));
//        products.add(new Items("Walking Sneakers", "https://cdn.britannica.com/04/123704-050-023DC490/Pair-leather-shoes.jpg", 732));
//        products.add(new Items("Athletic Sneakers", "https://marmishoes.com/media/wysiwyg/Newcat222.jpg", 507));
//        products.add(new Items("Hiking Boots", "https://www.campusshoes.com/cdn/shop/products/FIRST_11G-787_WHT-SIL-B.ORG.jpg", 620));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHjfY_VSTw2ps_vfN0OqK1Exl8Tr_XF2a-fg&s", 911));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSr7vMMCkAGfVaV6P9IdqWx05vHAuCqAAaGyA&s", 605));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVLNlJ1lwHpZM6pKzm3ruJs4BvZQZOH7I3JA&s", 712));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQM9ajAxSHg5wFBr6o4Sqd808WHWBEy1mmGA&s", 892));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZ5KPS45SBug8lRNis9EhfqDRo0D_Pn7q-kg&s", 850));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSvbVV8UBCu-_9xX5X0JJyApJkATA2pVUt6w&s", 988));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdQSl2ZVI8L-7Yb2Khqo6b1w34jabCkySIAA&s", 772));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRA_Psj0iyJvtxm30CyFhtnxCmN7crLjjBHEA&s", 718));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7U9ro1ASXQOnWnFcgA0KroHt9KkzxZbpUAA&s", 647));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVb62JQW0MI5T09KNEuU3-O82ls5mipybT_g&s", 515));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSU6utUwv5twcga9BUaUY1uM6-DrEKXbkindQ&s", 621));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT22HnqdNd9JzNT0BTvFVZi5tFgAXkzh_j_Hw&s", 991));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8a1sFTA-d2pSPuyUeLytHbt_pmrPNMXg_lg&s", 594));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN9bTmgTrZZ_Ca-hU-kV9huwgzKUqRDaISlw&s", 639));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPrBrW5GArIuZgrMDN19cGKDOZhHAMvkMbrw&s", 566));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS7cBg9Lk9pZCFqU8MXxUN9UGif4Xq1PktBA&s", 954));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_dIAwxlAgYJxDB_Yfmv7lFT-nxqm27pzCdw&s", 795));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKNYtzhPe7w5EAMPEAULTQRP06YASuIReE7Q&s", 590));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLZnSBE7Uo_ypt5t82oDNAWgYvIhdmRoyN8A&s", 828));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxp4Z6doe7zHc8W2KcYiadGdy7PtHldJfOEQ&s", 776));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCfh3n48ziakUdYbXrEISY5d6cQEBaOnL75Q&s", 778));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_ZMZr5jkxxuvF6BwSTLlC7lHg0Ct4TSbKVg&s", 696));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjjmnLMN0eBkPF3sGA7UCaGUV-M9z_ddFXQg&s", 700));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-yAFWnOHq3inhRbdbcbMIGi-E5UW4G4vtug&s", 690));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStdPguNzF9yIcyiD4Jc1TKEZPA_9kHbpVD4A&s", 541));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtdpoVKw495RL8MvfHuX8fIjhBU9jXuUJS1Q&s", 820));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlk70hrPVTmbf4uOIVXOCw327gf2CVk48ddQ&s", 889));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVth0k7qdE8CF5lOHia3NAKZXbjDZWOqapRA&s", 885));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2Nxi7IOTfspU_-9nFqAulg_Tw2tqwVg-wsQ&s", 602));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrloZ_lHhAsVRnPjAyVxigmOm_187ehKOaog&s", 507));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScKTLAwOymXq5jKaFb3QkwEb3g5fvxUHcNCA&s", 543));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ41btY8NmrEZe0Kd-clBfmOwR7tT38MrJfAA&s", 721));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5jWnzfAwmNnM5C3P-ob1WhxRZfqo4ml1Qcg&s", 600));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV1iYa90LEPv-Qa45BTvLlT7BKLis3n8QlSA&s", 538));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFm8-vI07bFb_ZZIVHebtkXLM8WJ3CvNsfxg&s", 652));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6ijaiiyUEq835HuMGADOUcUOFxw0WXn4mXA&s", 608));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1DWtNsQ6o_hTGg0idsJV-VL9iIS3PP-gDFw&s", 618));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEqH0VtvKEqDLXD80p3xgn_n4rQLF8mfkyqQ&s", 719));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTheNTwxw94fGF-o79OQOf8fnMNO2W8koQJrw&s", 975));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCQO1nbIAS2DVs516zVdCO8HDlUNIaAADHwQ&s", 1000));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRerwGT6K6UJbWw0hRzXVCxGUG35_u_0kI7_A&s", 610));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDO8H85hegne5mAtmG3-F0WYdZhekYu0CRMw&s", 913));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT77c8yYJK0s7PTV3wnQoFKyLBD8vMGiT8KRw&s", 606));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR05CDK6wHwPy4TIgUQivtjydS9KTM8sjpu-A&s", 595));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRD9f7scgL8Y35Wp1PEPpjXfEPe8VF_nlh1zg&s", 918));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrFPmzs8QwxzcOaeFsiXsJfgeKDM7y_tf7lA&s", 645));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREQM0Re0_bfdiL1ss2ZVdECyG9exJyWe6C6g&s", 701));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_h0iDJk1_vn0xTxvpSIPCTC0YlKpsOR0TKQ&s", 665));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmLUocZ2kdoxMcPAxE5pCcYASKPooHArDtGw&s", 619));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_dtTtBUTIk4505FtpB1eswvpsQmBZz-97SQ&s", 921));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2agiGBpGVr_p66dr1NsNaCFALX2YwlxR2eg&s", 911));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ_kL9_z1N-Sttu3MgiTD76wYZZsyi7DwW3A&s", 560));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUwQZtnOpVIyz6uAFcOy0JhJcVcV7vG1cUiQ&s", 849));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTn8SfVm34eY9PL3DKdp1bJ0G5zXvQ6CxAiqg&s", 774));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSU0fZQueAcHomXIzdQlFyVMRDj4-sOrg8B2A&s", 726));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9FrU-IzgQlFNeMPbf68cKpDiajqfcinJtsA&s", 644));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTMPzqJHNRwBCjsg187BbpnG7RPZrLUzRkpw&s", 566));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxPaD1rZRDGZlmDdydIVEwYaA8jKm5LZxv1w&s", 959));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgSRvlItC8KOjVVql5ees72DSS7Ze89BaRAg&s", 992));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKFEj1aG5jWpIo9iNaH_3E6XfpcA6WvntNWw&s", 677));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqTiwTbob-kn5ffho27KYo_L_rHIy1qRlxcw&s", 527));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuVzkTtRWS8bka2FHlL7OYN6H0YvlD3kTaCQ&s", 634));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0HKC1OzocAdd99TEY0ibFKhqW2MZABrSmaA&s", 935));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9-TM68KbRHEvGfAv7xm6Q1dSZhFqdzNBV9A&s", 875));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyq-HRVa5ABstW3cM6ly5xKWe2uWfeRMyv7A&s", 766));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQg-ghVC0K1ujXVbaHPzTgAPbDJFC4CuxefEw&s", 699));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlKbkBkB_Qx9PQv4mTuDTwGMDkaTCztrT-dQ&s", 926));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREPi8TjByXH9NBp5Bg1uFt80CEbzZA4MPd8g&s", 613));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1YrKnZ8wH_VYgGeXAkJOZnyrh3c-e3ne3jA&s", 920));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCLqu9FWrexHxWmpIzyPStz3x01ZBHgkFy1g&s", 685));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfWiKqKDEYJ15vRemCwRP1heT17O__lmZSjA&s", 522));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQO5Rjhj2DeCP04vWU2Ub7AyYASmVUonrHEaQ&s", 548));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRQuXVelY90vPtZZco0ON9hQK8tIB21TQaFg&s", 956));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxWLH_n9cmIAgcRAuA07CON4uvHR9JcGa0ZA&s", 716));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVvF2EqqUzf8K1INYugIi7QQbnG8atiJVpEw&s", 673));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGDyBXEdHPiZOMabEtZkF6iZGLQpI-ROP9HQ&s", 636));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTi2QuXDErfjmn7Q504aMbp7nSv5CprrTEcvA&s", 555));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1Lu2SJGEx4Qk5oHTOeyXcOb9C_dM9yzjm7A&s", 934));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2cTrHVs_4cuKMWbj-e9a5QUPdkWLLcOR23Q&s", 550));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjtxyzWgD1KMUsLwcLYRhRmyAl7Jd1MaTM7A&s", 635));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8Tb2b0FZUblRW2t9YDQLY4hF_JPx0msybIg&s", 720));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0tPh5vj-BHwVPgy_RJ2ubH1Atruo6dNQH1A&s", 641));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_n5n8EG94ZpP1tFG4FVmpCwHWkoVK0zJoag&s", 646));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTC1RJ1R-Kv1b2YD5kBQiym2xfPXY6KmWMjxg&s", 822));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjSjpEBZUm24S8y1uvQ4moritQbeYZ6npNDQ&s", 984));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoGFCZl1RfyNkhToTpX7HVVmQ6VnICs-YsKA&s", 914));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXF-sZ8ZHJVnDAPlsg6mdX3T4JNxVBly4yMA&s", 604));
//        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7KCGeISnII51ftFEdNIpevKXJbtOvgjF3zA&s", 745));
//        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIQWfHemHG2zGlQL-G0CIG__CNg6XG8JWiYQ&s", 929));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIBISmjjR3VW29QTHcIU_AO_JsVbZOaYOFdw&s", 831));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFiDE1VP89w4t1uVWajia2dpV6q9TFIXZKSQ&s", 523));
//        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXqtkIVQkKhn1Rpkq5jGCCTkO7sXkKKKAAnw&s", 624));
//        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSG8I_p0LzbndrkjMIyEXywvNDXhYS-JPS64g&s", 850));
//        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTe0GfNAZX7sHWevwMsct2AC3DPrK8WW2QD8A&s", 653));
//        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmd-57_gGyZtnAVwoxtxj3MoaR7vC0QD1nSg&s", 570));
        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHuhTE8-h829jJz5vYlwaAvZF68_TeakKyAw&s", 896));
        products.add(new Items("Dress Shoes", "data:image/jpeg;base64,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", 683));
        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_o0N4FLTMBceUCqi2JL78HXP8XU7i18rLYg&s", 915));
        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT12ksyUr5L7ucJReFSmPn8AqugyhLtTt9-Q&s", 763));
        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYwMbKjI7KLw1NwEkWWvillIbfTY8Une3F5A&s", 954));
        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpgYAmZG0eotljkUTEXoY6kTbeKGru7QomWQ&s", 674));
        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREvoTtvoOEws8EH1THd34RwSlOwgqjshSWBQ&s", 586));
        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgQADMn7pxNLLhNM7jj8PRGF8cWiqeChcKoQ&s", 989));
        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlmq5MPDawzeStKvDn7hMak2QXH9JxR5nrbA&s", 534));
        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNSzSoOgbROxiOefpc2EBoendLrzK5Fc49vw&s", 658));
        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUEiWh2KQe1bYG8z_b5A9doeB0XsPJbeDVTw&s", 936));
        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR679QT_WEL-gfNyZm6vcmQ8Yu5nygn6iIE6w&s", 568));
        products.add(new Items("Running Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeQt7edKNLd1nT0XNqOXdjBWiI4l7WdgBoxw&s", 937));
        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_7tLsxOzTqpmsKawVA1NbuWYpKcx0QVpQJw&s", 561));
        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSN_RFKGhWSYH5zK-SLAD3mI6B8L7_Wu2rP3A&s", 575));
        products.add(new Items("Hiking Boots", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpcL6MWcVjCKHLLTLp216GnrZeGvDttpn7Fg&s", 902));
        products.add(new Items("Casual Loafers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBfIYg5bYLfgx6-Wf75y0yzz0wPtrhvp7CTA&s", 721));
        products.add(new Items("Athletic Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRE29FkhutNxWqrvYooYrDzVVejMKiSE5QavQ&s", 717));
        products.add(new Items("Walking Sneakers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvD6-MIRTkTeWU0RgeFdlGMeDWCk4Ga3axOg&s", 621));
        products.add(new Items("Dress Shoes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmCbKoA-k_IjIOWA_jc30T1ffuQQNsES7Kcw&s", 916));



//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/PIcAAOSwQ0dmKET5/s-l1600.jpg", 3937));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/UTQAAOSw-0pmHr5N/s-l1600.jpg", 2771));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/UwUAAOSwn51mHr9m/s-l1600.jpg", 3310));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/K80AAOSwAzRl177j/s-l1600.jpg", 1015));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/pCgAAOSweaFl2Ogq/s-l1600.jpg", 2488));
//        products.add(new Items("Product", "https://i.ebayimg.com/00/s/MTkwWDEyMDA=/z/Kv4AAOSwrQZmK8mo/$_57.JPG", 8205));
//        products.add(new Items("Product", "https://ir.ebaystatic.com/rs/v/fxxj3ttftm5ltcqnto1o4baovyl.png", 9448));
        products.add(new Items("Product", "https://i.ebayimg.com/images/g/6TgAAOSwcudmK59r/s-l400.jpg", 4689));
      //  products.add(new Items("Product", "https://i.ebayimg.com/00/s/MTAwWDEyMDA=/z/J8wAAOSwk2tmKt11/$_57.JPG", 9945));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/HBoAAOSwLMZmGECK/s-l400.jpg", 9196));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/h~cAAOSwEEFmGD0i/s-l400.jpg", 2727));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/73MAAOSwEOtmGD8Y/s-l400.jpg", 6446));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/pRkAAOSwJ4JlAgWh/s-l400.jpg", 8996));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/8ywAAOSwQ1hlAgeN/s-l400.jpg", 1794));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/mXYAAOSwUThk6LV-/s-l400.jpg", 5941));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/W4wAAOSwQT1lggn6/s-l400.jpg", 5456));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/EuEAAOSwSYJk6LeC/s-l400.jpg", 8954));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/okAAAOSwVvFlgvjL/s-l400.jpg", 8675));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/3nIAAOSw8dNiR9mE/s-l300.jpg", 3350));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/Uj4AAOSwJstmL5Ag/s-l300.jpg", 9188));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/S6gAAOSw6ltlJILl/s-l300.jpg", 8150));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/154AAOSw5HRhbtT7/s-l300.jpg", 2535));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/gXsAAOSww2Zfu-Xf/s-l300.jpg", 2416));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/m4YAAOSwZCxl8Bi~/s-l300.jpg", 3014));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/DAEAAOSw-4BkglMr/s-l300.jpg", 7631));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/QZ0AAOSw6ill1QLp/s-l300.jpg", 3986));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/7fIAAOSwQ5VlNJul/s-l300.jpg", 7761));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/feQAAOSwrh9lYq8U/s-l300.jpg", 1487));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/LOYAAOSw3gFlaJZi/s-l300.jpg", 3654));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/iWUAAOSw7TJkQt2F/s-l300.jpg", 2293));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/I0oAAOSwxGZmL8e1/s-l300.jpg", 1434));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/IroAAOSwVQpmC1H7/s-l300.jpg", 569));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/Jy8AAOSwop1lcisM/s-l300.jpg", 1432));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/56cAAOSwhCxjcpHn/s-l300.jpg", 3054));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/5uYAAOSwHERlnatY/s-l300.jpg", 3447));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/VrcAAOSwk71mL6fz/s-l300.jpg", 4077));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/dIIAAOSwz7hl8B1u/s-l300.jpg", 8698));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/muYAAOSwTo9j9-Yl/s-l300.jpg", 8841));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/mIAAAOSwNZpk388s/s-l300.jpg", 9067));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/VO8AAOSwHOdmEBio/s-l300.jpg", 8238));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/epoAAOSw8BlmAXuW/s-l300.jpg", 3894));
//        products.add(new Items("Product", "https://i.ebayimg.com/images/g/pz8AAOSw2DhmFm4U/s-l300.jpg", 9484));

        //tyagi

//        products.add(new Items("Adidas UltraBoost", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Nike Air Max", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("New Balance Fresh Foam", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Brooks Ghost", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Asics Gel Kayano", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Saucony Ride", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Hoka One One Bondi", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Under Armour HOVR", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Mizuno Wave Rider", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Salomon Speedcross", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Merrell Moab", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Reebok Nano", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Puma Ignite", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Vans Old Skool", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Converse Chuck Taylor", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Timberland Classic", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Dr. Martens 1460", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Birkenstock Arizona", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Clarks Desert Boot", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("FILA Disruptor", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Skechers Go Walk", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Ecco Biom", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Keen Newport", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Columbia Newton Ridge", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Lowa Renegade", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("The North Face Hedgehog", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Merrell Jungle Moc", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Oboz Sawtooth", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Altra Lone Peak", "https://source.unsplash.com/random/200x200?shoes",1000));
//        products.add(new Items("Vivobarefoot Primus", "https://source.unsplash.com/random/200x200?shoes",1000));
        products.add(new Items("On Cloud", "https://source.unsplash.com/random/200x200?shoes",1000));
        products.add(new Items("Vibram FiveFingers", "https://cdn.pixabay.com/photo/2020/04/08/16/32/keyboard-5017973_1280.jpg",2000));
        products.add(new Items("Xero Shoes Prio", "https://source.unsplash.com/random/200x200?shoes",1000));


        // Add products to the list

        products.add(new Items("Fridge", "https://cdn.pixabay.com/photo/2016/10/24/21/03/appliance-1767311_640.jpg", 12000.00));
        products.add(new Items("Smart Phone", "https://img.freepik.com/free-vector/realistic-display-smartphone-with-different-apps_52683-30241.jpg", 12225.00));
        products.add(new Items("Water Dispenser", "https://c8.alamy.com/comp/HAY0F5/white-water-cooler-HAY0F5.jpg", 6450.00));
        products.add(new Items("Calculator", "https://upload.wikimedia.org/wikipedia/commons/c/cf/Casio_calculator_JS-20WK_in_201901_002.jpg", 1230.00));
        products.add(new Items("Comfy Chairs", "https://www.shutterstock.com/image-vector/vector-realistic-yellow-armchair-3d-600nw-2239751635.jpg", 3140.20));
        products.add(new Items("Smart Watch", "https://img.freepik.com/free-vector/realistic-fitness-trackers_23-2148530529.jpg", 4340.50));

        products.add(new Items("Fridge", "https://cdn.pixabay.com/photo/2016/10/24/21/03/appliance-1767311_640.jpg", 12000.00));
        products.add(new Items("Smart Phone", "https://img.freepik.com/free-vector/realistic-display-smartphone-with-different-apps_52683-30241.jpg", 12225.00));
        products.add(new Items("Water Dispenser", "https://c8.alamy.com/comp/HAY0F5/white-water-cooler-HAY0F5.jpg", 6450.00));
        products.add(new Items("Calculator", "https://upload.wikimedia.org/wikipedia/commons/c/cf/Casio_calculator_JS-20WK_in_201901_002.jpg", 1230.00));
        products.add(new Items("Comfy Chairs", "https://www.shutterstock.com/image-vector/vector-realistic-yellow-armchair-3d-600nw-2239751635.jpg", 3140.20));
        products.add(new Items("Smart Watch", "https://img.freepik.com/free-vector/realistic-fitness-trackers_23-2148530529.jpg", 4340.50));

        products.add(new Items("Fridge", "https://cdn.pixabay.com/photo/2016/10/24/21/03/appliance-1767311_640.jpg", 12000.00));
        products.add(new Items("Smart Phone", "https://img.freepik.com/free-vector/realistic-display-smartphone-with-different-apps_52683-30241.jpg", 12225.00));
        products.add(new Items("Water Dispenser", "https://c8.alamy.com/comp/HAY0F5/white-water-cooler-HAY0F5.jpg", 6450.00));
        products.add(new Items("Calculator", "https://upload.wikimedia.org/wikipedia/commons/c/cf/Casio_calculator_JS-20WK_in_201901_002.jpg", 1230.00));
        products.add(new Items("Comfy Chairs", "https://www.shutterstock.com/image-vector/vector-realistic-yellow-armchair-3d-600nw-2239751635.jpg", 3140.20));
        products.add(new Items("Smart Watch", "https://img.freepik.com/free-vector/realistic-fitness-trackers_23-2148530529.jpg", 4340.50));

        products.add(new Items("Fridge", "https://cdn.pixabay.com/photo/2016/10/24/21/03/appliance-1767311_640.jpg", 12000.00));
        products.add(new Items("Smart Phone", "https://img.freepik.com/free-vector/realistic-display-smartphone-with-different-apps_52683-30241.jpg", 12225.00));
        products.add(new Items("Water Dispenser", "https://c8.alamy.com/comp/HAY0F5/white-water-cooler-HAY0F5.jpg", 6450.00));
        products.add(new Items("Calculator", "https://upload.wikimedia.org/wikipedia/commons/c/cf/Casio_calculator_JS-20WK_in_201901_002.jpg", 1230.00));
        products.add(new Items("Comfy Chairs", "https://www.shutterstock.com/image-vector/vector-realistic-yellow-armchair-3d-600nw-2239751635.jpg", 3140.20));
        products.add(new Items("Smart Watch", "https://img.freepik.com/free-vector/realistic-fitness-trackers_23-2148530529.jpg", 4340.50));

        // Initially, display all products in the Recycler0.ew
        filteredList.addAll(products);

        // Set up RecyclerView with GridLayoutManager
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(this, 2));

        // Initialize adapter with the filtered list of products
        adapter = new ProductsAdapter(this, filteredList);
        recyclerViewProducts.setAdapter(adapter);

        // Add TextChangedListener to the search bar EditText
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Filter the list based on the search query
                filterProducts(s.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });
    }

    // Method to filter the product list based on search query
    private void filterProducts(String query) {
        filteredList.clear();

        if (query.isEmpty()) {
            // If the search query is empty, display all products
            filteredList.addAll(products);
        } else {
            // Filter products that contain the search query (case-insensitive)
            for (Items item : products) {
                if (item.getProductName().toLowerCase().contains(query)) {
                    filteredList.add(item);
                }
            }
        }

        // Notify adapter of changes in the filtered list
        adapter.notifyDataSetChanged();
    }
}
