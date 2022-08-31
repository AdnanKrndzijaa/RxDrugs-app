package com.example.rxdrugs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import com.example.rxdrugs.account.Login;
import com.example.rxdrugs.alldrugs.DrugsDB;
import com.example.rxdrugs.alldrugs.DrugsMain;
import com.example.rxdrugs.emergency.Emergency;
import com.example.rxdrugs.inventory.Inventory;
import com.example.rxdrugs.settings.Settings;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database.getInstance(this).drugsDAO().deleteAll();
        otcDB();
        prescriptionDB();

        AppCenter.start(getApplication(), "162c42a1-94ef-431e-9868-fdb263aebded",
                Analytics.class, Crashes.class);

        ImageButton menu = findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog buttonSheetDialog = new BottomSheetDialog(
                        MainActivity.this, R.style.BottomSheetDialogTheme
                );
                View buttonSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.bottom_sheet,
                                (LinearLayout)findViewById(R.id.bottom_sheet_container)
                        );
                buttonSheetView.findViewById(R.id.homeText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast message = Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT);
                        message.show();
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.drugText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, DrugsMain.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.inventoryText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alert("");
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.emergencyText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, Emergency.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.loginText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zombie("");
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetView.findViewById(R.id.settingsText).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, Settings.class);
                        startActivity(intent);
                        buttonSheetDialog.dismiss();
                    }
                });
                buttonSheetDialog.setContentView(buttonSheetView);
                buttonSheetDialog.show();
            }
        });

    }
    public void zombie(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_zombie_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        view.findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rxdrugs.herokuapp.com/app.html"));
                startActivity(intent);
            }
        });
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
    public void alert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_premium_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        view.findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rxdrugs.herokuapp.com/app.html"));
                startActivity(intent);
            }
        });
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
    }

    public void prescriptionDB() {
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Bactrim",
                "Sulphametoxazol + Trimetroprime",
                "Roche, Switzerland",
                "PRESCRIPTION",
                400,
                20,
                "What is Bactrim treat used for?\n" +
                        "This medication is a combination of two antibiotics: sulfamethoxazole and trimethoprim. It is used to treat a wide variety of bacterial infections.\n" +
                        "\n" +
                        "MEDICAL USES: middle ear, urine, respiratory, and intestinal infections, pneumonia\n" +
                        "SIDE-EFFECTS: nausea, vomiting, diarrhea, loss of appetite, skin rash, seizure, new or unusual joint pain, dry mouth\n" +
                        "INTERACTIONS: warfarin, dofetilide, methenamine, methotrexate\n" +
                        "DOSES: single dose is 1-2 pills, take 1-2 pills twice a day, in the morning and in the evening, depending on the severity of the infection\n",
                R.drawable.bactrim));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Aspirin Protect 100",
                "Acetylsalicylic acid",
                "BAYER, Germany",
                "PRESCRIPTION",
                100,
                30,
                "Aspirin protect 100 mg, gastro-resistant tablet is a medicine reserved for adults, and used to treat certain heart and vessel diseases that require blood thinning.\n" +
                        "\n" +
                        "MEDICAL USES: prevent heart attack, ischemic stroke\n" +
                        "SIDE-EFFECTS: alcohol, nausea, vomiting, stomach pain, bloody or tarry stools, coughing up blood or vomit, drowsines, mild headache\n" +
                        "INTERACTIONS: mifepristone, acetazolamide, \"blood thinners\" (such as warfarin, heparin), corticosteroids (such as prednisone), dichlorphenamide, methotrexate, valproic acid, herbal medications (such as ginkgo biloba)\n" +
                        "DOSES: single dose is 1 pill, max daily dose is 1-3 pills, prederably before meals\n",
                R.drawable.aspirin));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Lodix",
                "Furosemide",
                "Bosnalijek, Bosnia and Herzegovina",
                "PRESCRIPTION",
                40,
                10,
                "Lodix belongs to a group of medicines called loop diuretics (also known as water pills).\n" +
                        "\n" +
                        "MEDICAL USES: edema, hypertension, \n" +
                        "SIDE-EFFECTS: chest pain, shills, cough, fever, headache, painful or difficult urination, sore throat, wheezing\n" +
                        "INTERACTIONS: \n" +
                        "DOSES: single dose is 1 pill (but after it can increase to 2 pills), the normal max daily dose is 1-2 pills (but it depends, sometimes it can increase up to 4 pills per day)\n",
                R.drawable.lodix));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Lexilium",
                "Bromazepam",
                "Alkaloid Skopje, North Macedonia",
                "PRESCRIPTION",
                1.5,
                30,
                "Lexilium is used for anxiety, tension or agitation. Anxiety or tension associated with the normal stress of everyday life usually does not require treatment with medicines. Your doctor, however, may have prescribed Lexilium for another purpose.\n" +
                        "\n" +
                        "MEDICAL USES: Insomnia, Anxiety and other conditions\n" +
                        "SIDE-EFFECTS: Drowsiness, Decrease in libido, Impaired memory, Impaired psychomotor performance, Anterograde amnesia, Amnesic automatism, Dystonia\n" +
                        "INTERACTIONS: Cimetidine, Fluvoxamine, Propranolol\n" +
                        "DOSES: **Please consult your physician or pharmacist or refer to the product package.\n",
                R.drawable.lexilium));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Rotin",
                "Rosuvastatine",
                "Bosnalijek, Bosnia and Herzegovina",
                "PRESCRIPTION",
                5,
                30,
                "Rotin 10mg Tablet belongs to a group of medicines called statins. It is used to lower cholesterol and reduce the risk of heart disease. Cholesterol is a fatty substance that builds up in your blood vessels and causes narrowing, which may lead to a heart attack or stroke.\n" +
                        "\n" +
                        "MEDICAL USES: to lower cholesterol and reduce the risk of heart disease\n" +
                        "SIDE-EFFECTS: Muscle pain, Weakness, Headache, Abdominal pain, Dizziness, Joint pain, Nausea\n" +
                        "INTERACTIONS: Amiodarone, Acenocoumarol, Amlodipine, Benidipine\n" +
                        "DOSES: 1 pill per day - dosage depends on patient's therapy.\n",
                R.drawable.rotin));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Oximal",
                "Meloxikam",
                "Farmavita, Bosnia and Herzegovina",
                "PRESCRIPTION",
                15,
                30,
                "Oximal Tablet is used for the short-term treatment of symptoms of acute attacks of degenerative joint disease (also called as osteoarthritis). This medicine works by blocking the activity of chemicals released by the body that may cause fever, inflammation, and pain.\n" +
                        "\n" +
                        "MEDICAL USES: the long-term treatment of symptoms of pain, swelling, and inflammation in the joints (rheumatoid arthritis) and inflammation of the backbone (ankylosing spondylitis), and to treat sign and symptoms of joint inflammation (juvenile rheumatoid arthritis)\n" +
                        "SIDE-EFFECTS: constipation, diarrhea, gas fomation, headache, indigestion, influenza like symptoms, nausea, stomach pain, upper respiratory tract infections, vomiting\n" +
                        "INTERACTIONS: furosemide, thiazides, angiotensin-converting enzyme inhibitors, beta blockers, and angiotensin-II antagonists\n" +
                        "DOSES: 1 pill per day\n",
                R.drawable.oximal));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Esbesul",
                "Sulfametaxazole + Trimetoprime",
                "Bosnalijek, Bosnia and Herzegovina",
                "PRESCRIPTION",
                400,
                20,
                "ESBESUL is a combination of two antibacterial drugs sulfamethoxazole and trimethoprim. ESBESUL is used for the treatment of infections caused by sensitive microorganisms, as well as for the prevention of certain infections in adults and adolescents over 12 years of age.\n" +
                        "\n" +
                        "MEDICAL USES: Inflammation of the lungs (pneumonia) caused by the bacterium Pneumocystis jirovecii, Infections caused by a bacterium called Toxoplasma (toxoplasmosis).\n" +
                        "SIDE-EFFECTS: Difficulty breathing, Fainting, Swelling of the face, Swelling of the lips, tongue or throat which may be red and painful and/or cause difficulty swallowing, Chest pain, Red marks on the skin\n" +
                        "INTERACTIONS: Diuretics (medicines to make you urinate), Pyrimethamine, Cyclosporine, Medicines that prevent blood clotting, such as warfarin, Phenytoin, Medicines for the treatment of sugar (diabetes), such as glibenclamide, glipizide or tolbutamide and repaglinide, Rifampicin, an antibiotic\n" +
                        "DOSES: 1 pill per day\n",
                R.drawable.esbesul));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Marocen",
                "Ciprophloxacine",
                "Hemofarm, Bosnia and Herzegovina",
                "PRESCRIPTION",
                500,
                10,
                "The drug Marocen contains the active substance ciprofloxacin (in the form of ciprofloxacin hydrochloride) and belongs to the group of drugs called fluoroquinolones. Ciprofloxacin works by destroying the bacteria that cause infections. It only works on certain types of bacteria.\n" +
                        "\n" +
                        "MEDICAL USES: respiratory tract infections, ear or sinus infections that last for a long time or often recur, urinary tract infections, genital (sexual) organ infections in women and men, digestive and intra-abdominal infections, skin and soft tissue infections, bone and joint infections\n" +
                        "SIDE-EFFECTS: nausea, diarrhea, joint pain and joint inflammation in children, muscle weakness, burning, tingling, numbness, elevated body temperature, inflammation of internal organs, hematological disorders and systemic diseases\n" +
                        "INTERACTIONS: vitamin K antagonists or other oral anticoagulants, probenecid, methotrexate, theophylline), tizanidine, olanzapine, clozapine, ropinirole, phenytoin\n" +
                        "DOSES: 1-2 pills per day\n",
                R.drawable.marocen));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Enterofuryl",
                "Nipfuroxsazide",
                "Bosnalijek, Bosnia and Herzegovina",
                "PRESCRIPTION",
                200,
                16,
                "ENTEROFURYL 200 mg capsules are used in adults and children older than 6 years as an adjunct to rehydration in the treatment of acute diarrhea (sudden onset diarrhea) caused by an intestinal infection.\n" +
                        "\n" +
                        "MEDICAL USES: as an adjunct to rehydration in the treatment of acute diarrhea (sudden onset diarrhea) caused by an intestinal infection\n" +
                        "SIDE-EFFECTS: skin eruption, itching, hives, sudden swelling of the face and/or neck that can cause difficulty breathing and be life-threatening\n" +
                        "INTERACTIONS: Simultaneous use of Enterofuryl with drugs that can cause a disulfiram reaction or with depressants of the central nervous system is not recommended.\n" +
                        "DOSES: depends, but usually 1-2 capsules per day\n",
                R.drawable.enterfuryl));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Prilenap H",
                "Enapril, Hidrohloratiazide",
                "Hemofarm, Bosnia and Herzegovina",
                "PRESCRIPTION",
                35,
                30,
                "Enalapril belongs to a group of medicines known as ACE inhibitors, which work by dilating blood vessels. Hydrochlorothiazide belongs to a group of drugs known as diuretics (for removing excess fluid from the body), which work by increasing urine output.\n" +
                        "\n" +
                        "MEDICAL USES: high blood pressure (arterial hypertension)\n" +
                        "SIDE-EFFECTS: allergic reaction – itching, shortness of breath or wheezing in the chest, as well as swelling of the hands, mouth, throat, face or eyes may occur, lightheadedness, dizziness, especially at the beginning of therapy, when you stand up or when you take a larger dose of the drug\n" +
                        "INTERACTIONS: potassium supplements, other medicines to lower blood pressure, thiazides, furosemide, bumetanide, barbiturates, tricyclic antidepressants such as amitriptyline, pain relievers such as morphine or anesthetics, cholestyramine or colestipol\n" +
                        "DOSES: 1 pill per day - dosage will prescribe a doctor\n",
                R.drawable.prilenaph));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Controloc",
                "Pantoprazole",
                "Takeda PBmbH, Germany",
                "PRESCRIPTION",
                20,
                28,
                "Controloc contains the active substance pantoprazole. Controloc is a selective \"proton pump inhibitor\", a drug that reduces the amount of acid produced in your stomach. It is used to treat stomach and intestinal diseases caused by acid.\n" +
                        "\n" +
                        "MEDICAL USES: treatment of symptoms such as heartburn, reflux of acid from the stomach into the mouth, pain when swallowing associated with gastroesophageal reflux disease caused by the reflux of acid from the stomach into the esophagus, long-term treatment of reflux esophagitis and prevention of the return of the disease.\n" +
                        "SIDE-EFFECTS: swelling of the tongue and/or throat, difficulty in swallowing, hives (urticaria), difficulty in breathing, allergic swelling of the face (angioedema), severe dizziness with very fast heartbeat and profuse sweating\n" +
                        "INTERACTIONS: ketoconazole, warfarin or phenprocoumon, atazanavir, methotrexate, fluvoxamine\n" +
                        "DOSES: 1 pill per day (can be used 2-3 times max)\n",
                R.drawable.controloc));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Metrozol",
                "Metronidazole",
                "Bosnalijek, Bosnia and Herzegovina",
                "PRESCRIPTION",
                500,
                10,
                "METROZOL contains the drug metronidazole, an active substance from the group of nitroimidazoles, which acts on the causative agents of certain infections (primarily anaerobic bacteria and some parasites). METROZOL works by killing bacteria and parasites that cause infections in your body.\n" +
                        "\n" +
                        "MEDICAL USES: Giardiasis, Acute ulcerative gingivitis, Acute dental infections, Eradication of Helicobacter pylori, Active Chron's disease, Diarrhea, Clostridium difficile\n" +
                        "SIDE-EFFECTS: Swelling of the hands, feet, ankles, face, lips or throat, which may cause difficulty in swallowing and breathing.\n" +
                        "INTERACTIONS: Medicines to thin the blood, such as warfarin, Lithium for the treatment of mental illness, Phenobarbitone or phenytoin for the treatment of epilepsy, 5-fluorouracil for the treatment of cancer\n" +
                        "DOSES: max single dose is 1-2 pills, 2-4 pills per day\n",
                R.drawable.metrozol));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Belogent Cream",
                "Betametazon, Gentamicin",
                "Farmavita, Bosnia and Herzegovina",
                "PRESCRIPTION",
                1.5,
                30,
                "Belogent Cream provide in each gram 0.64 mg of betamethasone dipropionate equivalent to 0.5 mg (0.05%) of betamethasone and gentamicin sulfate, equivalent to 1 mg (0.1%) of gentamicin base.\n" +
                        "\n" +
                        "MEDICAL USES: psoriasis, contact dermatitis (dermatitis venenata), atopic dermatitis (infantile eczema, allergic dermatitis), neurodermatitis (lichen simplex chronicus), lichen planus, eczema (including nummular eczema, hand eczema, eczematous dermatitis), intertrigo, dyshidrosis (pompholyx), seborrheic dermatitis, exfoliative dermatitis, solar dermatitis, stasis dermatitis, and anogenital and senile pruritus\n" +
                        "SIDE-EFFECTS: hypersensitivity and skin discoloration\n" +
                        "INTERACTIONS: other medical products like creams or ointments\n" +
                        "DOSES: ///\n",
                R.drawable.belogent));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Voltaren suppositories",
                "Metronidazole",
                "Bosnalijek, Bosnia and Herzegovina",
                "PRESCRIPTION",
                500,
                10,
                "Voltaren relieves pain and reduces inflammation (swelling and redness) that may occur in the following: different types of arthritis including rheumatoid arthritis and osteoarthritis, other painful conditions where swelling is a problem such as back pain, rheumatism, muscle strains.\n" +
                        "\n" +
                        "MEDICAL USES:  relieve pain, swelling (inflammation), and joint stiffness caused by arthritis\n" +
                        "SIDE-EFFECTS: Hypersensitivity to the active substance or any of the excipients, Active, gastric or intestinal ulcer, bleeding or perforation, History of gastrointestinal bleeding or perforation, relating to previous NSAID therapy, Active, or history of recurrent peptic ulcer/haemorrhage (two or more distinct episodes of proven ulceration or bleeding), Last trimester of pregnancy\n" +
                        "INTERACTIONS: antidepressants, blood thinners, cyclosporine, isoniazid, lithium, methotrexate, pronbenecid, zafirlukast, diuretics (water pills), steroids, aspirin\n" +
                        "DOSES: 1-2 suppositories per day\n",
                R.drawable.voltaren));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Protecta",
                "Simvastatine",
                "Farmavita, Bosnia and Herzegovina",
                "PRESCRIPTION",
                20,
                28,
                "PROTECTA is a medicine that lowers the level of total cholesterol, \"bad\" cholesterol (LDL cholesterol) and fatty substances, called triglycerides, in the blood. PROTECTA also raises the level of \"good\" cholesterol (HDL cholesterol). PROTECTA belongs to a group of medicines called statins.\n" +
                        "\n" +
                        "MEDICAL USES: high level of total cholesterol\n" +
                        "SIDE-EFFECTS: swelling of the face, tongue and throat which may cause difficulty breathing (angioedema), severe pain in the muscles, usually in the shoulders and hips, rash and weakness in the muscles of the arms, legs and neck, pain or inflammation of the joints (polymyalgia rheumatica), inflammation of blood vessels ( vasculitis)\n" +
                        "INTERACTIONS: ciclosporin, danazol, medicines containing active substances such as itraconazole, ketoconazole, fluconazole, posaconazole, voriconazole, erythromycin, clarithromycin, telithromycin or fusidic acid\n" +
                        "DOSES: 1 pill per day - **depends on the therapy\n",
                R.drawable.protecta));

        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Legofer",
                "Ferric proteinsuccinylate",
                "Alkaloid Skopje, North Macedonia",
                "PRESCRIPTION",
                800,
                150,
                "Legofer belongs to the group of oral antianemics (medicines for the treatment of anemia) that contain trivalent iron. It is used to prevent and treat anemia caused by iron deficiency, helping the body to produce red blood cells.\n" +
                        "\n" +
                        "MEDICAL USES: for the prevention and treatment of anemia (anemia) caused by iron deficiency\n" +
                        "SIDE-EFFECTS: difficulty breathing, swelling of the face, lips, mouth, tongue or throat, severe rash and itching.\n" +
                        "INTERACTIONS: antibiotics, bisphosphonates, thyroxine (thyroid hormone), levodopa, carbidopa (for the treatment of Parkinson's disease), alpha-methyldopa, ascorbic acid (vitamin C), antacids (to neutralize stomach acids), preparations containing zinc, dimercaprol\n" +
                        "DOSES: 1 dose per day\n",
                R.drawable.legofer));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Brufen 600",
                "Ibuprofen",
                "Mylan, United States",
                "PRESCRIPTION",
                600,
                10,
                "Brufen 600 pill is a pain-relieving medicine. It is used to treat many conditions such as headache, fever, period pain, toothache, colds, and mild arthritis. It is also a common ingredient in many cold and flu remedies.\n" +
                        "\n" +
                        "MEDICAL USES: headache, fever, period pain, toothache, colds, and mild arthritis\n" +
                        "SIDE-EFFECTS: Vomiting, Nausea, Dizziness, Abdominal pain, Constipation, Diarrhea, Headache, Rash, Fatigue\n" +
                        "INTERACTIONS: Nimesulide, Oxyphenbutazone, Metamizole\n" +
                        "DOSES: single dose is 1-2 pills, time between doses is 4-6 hours, max daily dose is 4 pills\n",
                R.drawable.brufen600));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Hernovir Cream",
                "Acyclovir",
                "NOBEL, Turkiye",
                "PRESCRIPTION",
                50,
                10,
                "HERNOVIR is an effective antiviral drug against Herpes simplex (HSV) I and II and Varicella zoster viruses. HERNOVIR contains acyclovir as an active ingredient. HERNOVIR should not be mixed with creams or other oils.\n" +
                        "\n" +
                        "MEDICAL USES: for Herpes simplex (HSV) I and II and Varicella zoster viruses\n" +
                        "SIDE-EFFECTS: Dry/cracked lips, burning, stinging, or flaky skin may occur\n" +
                        "INTERACTIONS: ///\n" +
                        "DOSES: 5 times a day (every 3 to 4 hours) for 4 days\n",
                R.drawable.hernovir));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Natrii Chloridi Infundibile",
                "NaCl 9%",
                "Hemofarm, Bosnia and Hezegovina",
                "PRESCRIPTION",
                0.9,
                500,
                "NaCl 9% is used for treatment of fluid loss and to restore sodium chloride balance. It is used in the treatment of patients who are unable to take fluids and nutrients by mouth. It is also used for dilution of other medicines before injection into the body.\n" +
                        "\n" +
                        "MEDICAL USES: fluid loss\n" +
                        "SIDE-EFFECTS: Anxiety, burning pain in lower abdomen, chest pain, severe, feeling of heat, feeling of warmth in the lips and tongue, headache (severe or dull), numbness of the fingertips, pain in lower back, pelvis, or stomach.\n" +
                        "INTERACTIONS: sodium/water imbalance. acidosis.\n" +
                        "DOSES: 1-2 doses\n",
                R.drawable.nacl));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Plivatinib/Imatinib",
                "Imatinib",
                "PLIVA, Croatia",
                "PRESCRIPTION",
                100,
                60,
                "Imatinib is a type of cancer growth blocker called a tyrosine kinase inhibitor (TKI). Tyrosine kinases are proteins that cells use to signal to each other to grow. They act as chemical messengers. There are a number of different tyrosine kinases and blocking them stops the cancer cells growing.\n" +
                        "\n" +
                        "MEDICAL USES: for certain types of leukemia (cancer that begins in the white blood cells) and other cancers and disorders of the blood cells\n" +
                        "SIDE-EFFECTS: Abdominal or stomach pain, cramping, burning, or tenderness, bleeding from wound after surgery, bleeding problems, loating or swelling of the face, hands, lower legs, or feet, blood in the urine, bloody eye, bloody nose, blue lips and fingernails.\n" +
                        "INTERACTIONS: dexamethasone, phenytoin, carbamazepine, rifampicin, phenobarbital, fosphenytoin, primidone or St. John's wort\n" +
                        "DOSES: ***depends (SPECIAL DRUG APPROVAL REQUIRED)\n",
                R.drawable.imatinib));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Afloderm Cream",
                "alclometazone",
                "BELUPO, Croatia",
                "PRESCRIPTION",
                0.5,
                20,
                "This medicine contains active ingredient alclometasone dipropionate, which belongs to a group of medicines called topical corticosteroids that are also referred to as topical steroids.\n" +
                        "\n" +
                        "MEDICAL USES: eczema or dermatitis flare-up by reducing inflammation, itching and redness\n" +
                        "SIDE-EFFECTS: redness, swelling, itching of the skin (signs of an allergic reaction), worsening of the condition being treated, irritation, burning or stinging sensation after applying the cream\n" +
                        "INTERACTIONS: other medical products like creams or ointments for skin\n" +
                        "DOSES: ///\n",
                R.drawable.aflodermcream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Afloderm Ointment",
                "alclometazone",
                "BELUPO, Croatia",
                "PRESCRIPTION",
                0.5,
                20,
                "This medicine contains active ingredient alclometasone dipropionate, which belongs to a group of medicines called topical corticosteroids that are also referred to as topical steroids.\n" +
                        "\n" +
                        "MEDICAL USES: eczema or dermatitis flare-up by reducing inflammation, itching and redness\n" +
                        "SIDE-EFFECTS: redness, swelling, itching of the skin (signs of an allergic reaction), worsening of the condition being treated, irritation, burning or stinging sensation after applying the cream\n" +
                        "INTERACTIONS: other medical products like creams or ointments for skin\n" +
                        "DOSES: ///\n",
                R.drawable.aflodermointment));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Tobrex Eye Drops",
                "Tobramicin",
                "Alcon, Belgium",
                "PRESCRIPTION",
                3,
                5,
                "This medication is used to treat eye infections. Tobramycin belongs to a class of drugs called aminoglycoside antibiotics. It works by stopping the growth of bacteria.This medication treats only bacterial eye infections. \n" +
                        "\n" +
                        "MEDICAL USES: eye infections\n" +
                        "SIDE-EFFECTS: rash, itching/swelling (especially of the face/tongue/throat), severe dizziness, trouble breathing\n" +
                        "INTERACTIONS: other medical products like eye drops\n" +
                        "DOSES: 6 drops per day\n",
                R.drawable.tobrex));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Maxidex Eye Drops",
                "Dexamethasone",
                "Alcon, Belgium",
                "PRESCRIPTION",
                1,
                5,
                "This medication is used to treat eye infections. Tobramycin belongs to a class of drugs called aminoglycoside antibiotics. It works by stopping the growth of bacteria.This medication treats only bacterial eye infections. \n" +
                        "\n" +
                        "MEDICAL USES: anterior uveitis, iritis, cyclitis, allergic and vernal conjunctivitis, herpes zoster keratitis, superficial punctate keratitis and non-specific superficial keratitis\n" +
                        "SIDE-EFFECTS: Vaccinia, varicella, or other viral diseases of cornea and conjunctiva (except herpes zoster keratitis), Herpes simplex keratitis, Fungal diseases of ocular structures or untreated parasitic eye infections, Mycobacterial ocular infections, Acute, untreated bacterial infections, Hypersensitivity to dexamethasone\n" +
                        "INTERACTIONS: other medical products like eye drops\n" +
                        "DOSES: 6 drops per day\n",
                R.drawable.maxidex));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Panicillin",
                "bensylpenicillin, bensylpenicillin-procain",
                "Hemofarm, Bosnia and Herzegovina",
                "PRESCRIPTION",
                0,
                5,
                "The drug Pancillin powder for suspension for injection contains as active substances benzylpenicillin and benzylpenicillinprocaine, which belong to the group of antibiotics known as penicillins. It is used in the treatment of infections caused by bacteria that are sensitive to this antibiotic.\n" +
                        "\n" +
                        "MEDICAL USES: Uncomplicated cases of pneumococcal pneumonia (pneumonia), Streptococcal infections (angina, scarlet fever, sinusitis - inflammation of the sinus mucosa), Diphtheria, Gonorrhea, Syphilis\n" +
                        "SIDE-EFFECTS: skin rash and itching, difficulty breathing and wheezing in the chest; swelling of the eyelids, face or lips, swollen or red tongue, fever or chills, joint pain, sudden drop in blood pressure\n" +
                        "INTERACTIONS: antibiotics, probenecide, aminoglycosides, clavulanic acid, methotrexate, sulfinpyrazone\n" +
                        "DOSES: 1.2 g per day, during 10-14 days - *As a rule, the preparation is given once a day, but in severe infections it can be given for 12 hours*\n",
                R.drawable.panicillin));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Diprogenta Cream",
                "betamethasone + gentamicin",
                "Merck Sharp & Dohme, Malaysia",
                "PRESCRIPTION",
                0,
                5,
                "DIPROGENTA Cream provide in each gram 0.64 mg of betamethasone dipropionate equivalent to 0.5 mg (0.05%) of betamethasone and gentamicin sulfate, equivalent to 1 mg (0.1%) of gentamicin base.\n" +
                        "\n" +
                        "MEDICAL USES: psoriasis, contact dermatitis (dermatitis venenata), atopic dermatitis (infantile eczema, allergic dermatitis), neurodermatitis (lichen simplex chronicus), lichen planus, eczema (including nummular eczema, hand eczema, eczematous dermatitis), intertrigo, dyshidrosis (pompholyx), seborrheic dermatitis, exfoliative dermatitis, solar dermatitis, stasis dermatitis, and anogenital and senile pruritus\n" +
                        "SIDE-EFFECTS: hypersensitivity and skin discoloration\n" +
                        "INTERACTIONS: other medical products like creams or ointments\n" +
                        "DOSES: ///\n",
                R.drawable.diprogentacream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Diprogenta Ointment",
                "betamethasone + gentamicin",
                "Merck Sharp & Dohme, Malaysia",
                "PRESCRIPTION",
                0,
                5,
                "DIPROGENTA Ointment provide in each gram 0.64 mg of betamethasone dipropionate equivalent to 0.5 mg (0.05%) of betamethasone and gentamicin sulfate, equivalent to 1 mg (0.1%) of gentamicin base.\n" +
                        "\n" +
                        "MEDICAL USES: psoriasis, contact dermatitis (dermatitis venenata), atopic dermatitis (infantile eczema, allergic dermatitis), neurodermatitis (lichen simplex chronicus), lichen planus, eczema (including nummular eczema, hand eczema, eczematous dermatitis), intertrigo, dyshidrosis (pompholyx), seborrheic dermatitis, exfoliative dermatitis, solar dermatitis, stasis dermatitis, and anogenital and senile pruritus\n" +
                        "SIDE-EFFECTS: hypersensitivity and skin discoloration\n" +
                        "INTERACTIONS: other medical products like creams or ointments\n" +
                        "DOSES: ///\n",
                R.drawable.diprogentaointment));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Bethagen Cream",
                "betamethasone + gentamicin",
                "Bosnalijek, Bosnia and Herzegovina",
                "PRESCRIPTION",
                1.5,
                15,
                "Bethagen Cream provide in each gram 0.5 mg of betamethasone dipropionate equivalent to 0.5 mg (0.05%) of betamethasone and gentamicin sulfate, equivalent to 1 mg (0.1%) of gentamicin base.\n" +
                        "\n" +
                        "MEDICAL USES: psoriasis, contact dermatitis (dermatitis venenata), atopic dermatitis (infantile eczema, allergic dermatitis), neurodermatitis (lichen simplex chronicus), lichen planus, eczema (including nummular eczema, hand eczema, eczematous dermatitis), intertrigo, dyshidrosis (pompholyx), seborrheic dermatitis, exfoliative dermatitis, solar dermatitis, stasis dermatitis, and anogenital and senile pruritus\n" +
                        "SIDE-EFFECTS: hypersensitivity and skin discoloration\n" +
                        "INTERACTIONS: other medical products like creams or ointments\n" +
                        "DOSES: ///\n",
                R.drawable.bethagen));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Pronerv",
                "cyanocobalamin, pyridoxine, thiamine",
                "G.L.Pharma GmBH, Germany",
                "PRESCRIPTION",
                200,
                20,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.pronerv));
    }
    public void otcDB() {
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Caffetin",
                "codeine, paracetamol, propyphenazone, caffeine",
                "Alkaloid Skopje, North Macedonia",
                "OTC",
                470,
                12,
                "Caffetin is indicated for relief of different type of pain. Paracetamol, propyphenazone and codeine have analgesic effects, whereas caffeine is considered an adjuvant which enhances the analgesic effect.\n" +
                        "\n" +
                        "MEDICAL USES: headache, toothache, migraine, neuralgia, ishialgia, muscular pain, postoperative, posttraumatic and menstrual pain\n" +
                        "SIDE-EFFECTS: skin rashes, pruritus (itching), erythema, angioedema, breathing problems such as dyspnea and asthma, anaphylaxis (serious allergic reactions), and decrease in the number of blood cells such as thrombocytopenia, leucopenia, agranulocytosis, and pancytopenia\n" +
                        "INTERACTIONS: alcohol, paracetamol, caffeine\n" +
                        "DOSES: single dose is 1-2 pills, time between doses is 4-6 hours, max daily dose is 6 pills\n",
                R.drawable.caffetin));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Dulcolax suppositories",
                "Bisacodyl",
                "PLIVA, Croatia",
                "OTC",
                10,
                10,
                "This product is used to treat constipation. However, milder products (such as laxatives taken by mouth) should be used whenever possible for constipation.\n" +
                        "\n" +
                        "MEDICAL USES: constipation\n" +
                        "SIDE-EFFECTS: rectal irritation/burning/itching, mild abdominal discomfort/cramps, nausea\n" +
                        "INTERACTIONS: other laxatives (castor oil, stool softeners, lubricants such as mineral oil)\n" +
                        "DOSES: Gently insert the suppository, pointed end first, toward the navel and well up into the rectum. After insertion, stay in position for 15 to 20 minutes if possible until you feel a strong urge to have a bowel movement.\n",
                R.drawable.dulcolax));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Paracetamol",
                "Paracetamol",
                "Alkaloid Skopje, North Macedonia",
                "OTC",
                500,
                10,
                "Paracetamol is an analgesic and antipyretic drug that is used to temporarily relieve mild-to-moderate pain and fever.\n" +
                        "\n" +
                        "MEDICAL USES: headache, migraine, backache, rheumatic and muscle pain, toothache, period pain, colds and flue symptoms, sore throat, fever\n" +
                        "SIDE-EFFECTS: allergic reactions (skin rashes, itching, hives, swelling of the throat, tongue or face, shortness of breath or wheezing), skin rash, breathing and liver problems\n" +
                        "INTERACTIONS: anticoagulants, cholestyramine, lamotrigine, isoniazide, aspirin, salicylamide, flucloxacillin, amitriptyline\n" +
                        "DOSES: single dose is 1-2 pills, time between doses is 4-6 hours, max daily dose is 8 pills\n",
                R.drawable.paracetamol));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Reumogal",
                "Metronidazole",
                "GALAS, Bosnia and Herzegovina",
                "OTC",
                0,
                1,
                "This product is used externally and is an excellent product for pain in muscles, bones, rheumatism, or any other type of pain in the body.\n" +
                        "\n" +
                        "MEDICAL USES: rheumatism, bone pain, muscle pain, ...\n" +
                        "SIDE-EFFECTS: none\n" +
                        "INTERACTIONS: none\n" +
                        "DOSES: ///\n",
                R.drawable.reumogal));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Effaclar Gel",
                "Sodium laureth sulfate, PEG-8, hexylene glycol, sodium chloride, citric acid",
                "LA ROCHE-POSAY, France",
                "OTC",
                0.5,
                15,
                "Purifying foaming gel for oily sensitive skin\n" +
                        "\n" +
                        "MEDICAL USES: oily sensitive skin\n" +
                        "SIDE-EFFECTS: none\n" +
                        "INTERACTIONS: none\n" +
                        "DOSES: 1-2 times per day\n",
                R.drawable.effaclargel));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Synopen ointment",
                "chloropiramine",
                "PLIVA, Croatia",
                "OTC",
                10,
                20,
                "This drug reduces the effects of histamine by disabling histamine receptors to bind with histamine. If this binding is not disabled, we have symptoms such as itching.\n" +
                        "\n" +
                        "MEDICAL USES: insect bites, and itching\n" +
                        "SIDE-EFFECTS: photosensitivity, hypersensitivity reactions, hives\n" +
                        "INTERACTIONS: other skin products on the place where Synopen is applied\n" +
                        "DOSES: 1-2 times on the skin (but can be used mre times if it is necessary)\n",
                R.drawable.synopen));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Avene Cleanance Comedomed",
                "isopropyl alcohol, aqua, glycerin, silica",
                "Pierre Fabre, France",
                "OTC",
                0,
                100,
                "This product is non-oily daily moisturiser for the face that helps to fight blemishes.\n" +
                        "\n" +
                        "MEDICAL USES: *skincare product, only for normal to combo skin, dry or sensitive skin with breakouts\n" +
                        "SIDE-EFFECTS: *do not use on the normal, dry or sensitive skin\n" +
                        "INTERACTIONS: other skin products on the place where Comedomed is applied\n" +
                        "DOSES: ///\n",
                R.drawable.comedomed));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Magnesium + Calcium + D3",
                "Magnesium, calcium, vitamine D3",
                "Mivolis dm, Germany",
                "OTC",
                750,
                45,
                "This product is commercial and contains all natural ingredients.\n" +
                        "\n" +
                        "MEDICAL USES: *commercial product, excellent for prevention of convulsions\n" +
                        "SIDE-EFFECTS: none\n" +
                        "INTERACTIONS: none\n" +
                        "DOSES: ///\n",
                R.drawable.mgcad3));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Glukozamine Cream",
                "Glucozamine",
                "Herbamedicus, Germany",
                "OTC",
                0,
                250,
                "This product is commercial and contains all natural ingredients.\n" +
                        "\n" +
                        "MEDICAL USES: *commercial product, excellent for prevention of bone and muscle pains\n" +
                        "SIDE-EFFECTS: none\n" +
                        "INTERACTIONS: none\n" +
                        "DOSES: ///\n",
                R.drawable.glucozamine));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Brufen 400",
                "Ibuprofen",
                "Mylan, United States",
                "OTC",
                400,
                10,
                "Brufen 400 pill is a pain-relieving medicine. It is used to treat many conditions such as headache, fever, period pain, toothache, colds, and mild arthritis. It is also a common ingredient in many cold and flu remedies.\n" +
                        "\n" +
                        "MEDICAL USES: headache, fever, period pain, toothache, colds, and mild arthritis\n" +
                        "SIDE-EFFECTS: Vomiting, Nausea, Dizziness, Abdominal pain, Constipation, Diarrhea, Headache, Rash, Fatigue\n" +
                        "INTERACTIONS: Nimesulide, Oxyphenbutazone, Metamizole\n" +
                        "DOSES: single dose is 1-2 pills, time between doses is 4-6 hours, max daily dose is 6 pills\n",
                R.drawable.brufen400));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "OHB-12",
                "Hydroxocobalamin",
                "GALENIKA AD BEOGRAD, Serbia",
                "OTC",
                2500,
                1,
                "Cyanokit is indicated for the treatment of known or suspected cyanide poisoning. Cyanide poisoning may result from inhalation, ingestion, or dermal exposure to various cyanide-containing compounds, including smoke from closed-space fires.\n" +
                        "\n" +
                        "MEDICAL USES: Burns, Smoke Inhalation, Hypertension, Hypotension, Headache, Coma, Dyspnea, Poisoning, Cyanide Poisoning, Panic, Seizure, Burping, Morning Sickness\n" +
                        "SIDE-EFFECTS: Swelling of the lips and face, difficulty breathing, rash and reddening of the skin, irregular heartbeat, fever, itching, headache, nausea or vomiting, diarrhea, tremors, skin changes.\n" +
                        "INTERACTIONS: antibiotics, antimetabolits\n" +
                        "DOSES: 1 injection per month, after some time 1 injection per 2 months, etc\n",
                R.drawable.ohb));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Caffebol",
                "codeine, paracetamol, caffeine",
                "Hemofarm AD Vršac, Serbia",
                "OTC",
                520,
                12,
                "Caffebol is indicated for relief of different type of pain. Paracetamol and codeine have analgesic effects, whereas caffeine is considered an adjuvant which enhances the analgesic effect.\n" +
                        "\n" +
                        "MEDICAL USES: headache, toothache, migraine, neuralgia, ishialgia, muscular pain, postoperative, posttraumatic and menstrual pain\n" +
                        "SIDE-EFFECTS: skin rashes, pruritus (itching), erythema, angioedema, breathing problems such as dyspnea and asthma, anaphylaxis (serious allergic reactions), and decrease in the number of blood cells such as thrombocytopenia, leucopenia, agranulocytosis, and pancytopenia\n" +
                        "INTERACTIONS: alcohol, paracetamol, caffeine\n" +
                        "DOSES: single dose is 1-2 pills, time between doses is 4-6 hours, max daily dose is 6 pills\n",
                R.drawable.caffebol));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Plivadon",
                "codeine, paracetamol, propyphenazone, caffeine",
                "PLIVA, Croatia",
                "OTC",
                495,
                12,
                "Plivadon is indicated for relief of different type of pain. Paracetamol, propyphenazone and codeine have analgesic effects, whereas caffeine is considered an adjuvant which enhances the analgesic effect.\n" +
                        "\n" +
                        "MEDICAL USES: headache, toothache, migraine, neuralgia, ishialgia, muscular pain, postoperative, posttraumatic and menstrual pain\n" +
                        "SIDE-EFFECTS: skin rashes, pruritus (itching), erythema, angioedema, breathing problems such as dyspnea and asthma, anaphylaxis (serious allergic reactions), and decrease in the number of blood cells such as thrombocytopenia, leucopenia, agranulocytosis, and pancytopenia\n" +
                        "INTERACTIONS: alcohol, paracetamol, caffeine\n" +
                        "DOSES: single dose is 1-2 pills, time between doses is 4-6 hours, max daily dose is 6 pills\n",
                R.drawable.plivadon));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Clindamycin",
                "clindamycin",
                "Bosnalijek, Bosnia and Herzegovina",
                "OTC",
                0,
                0,
                "Clindamycin is an antibiotic that fights bacteria in the body. Clindamycin is used to treat serious infections caused by bacteria. Clindamycin may also be used for purposes not listed in this medication guide.\n" +
                        "\n" +
                        "MEDICAL USES: infections of the lungs, skin, blood, female reproductive organs, and internal organs\n" +
                        "SIDE-EFFECTS: diarrhea, little or no urination, nausea, vomiting, stomach pain, mild skin rash, a metallic taste in your mouth\n" +
                        "INTERACTIONS: Atracurium, Cisatracurium, Mivacurium, Pancuronium, Rocuronium, Suxamethonium, Vecuronium\n" +
                        "DOSES: ///\n",
                R.drawable.clindamycin));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Effaclar DUO+ UNIFIANT",
                "clindamycin",
                "LA ROCHE-POSAY, France",
                "OTC",
                0,
                40,
                "Effaclar Duo (+) Unifant Tinted Anti-Acne Moisturiser is a sheer tinted moisturiser designed to deliver light coverage whilst targeting blemishes, imperfections and marks. Immediately, imperfections and marks look reduced and the complexion is naturally unified, without a mask like finish. Effaclar Duo Medium is ideal for those with oily, imperfection-prone skin with clogged pores, Effaclar Duo Plus Unifant Tinted Anti-Acne Moisturiser is formulated with ingredients that help protect against the appearance of red or brown marks, balance oiliness, and help reduce redness. This unclogging tinted moisturiser for blemish-prone skin is available in two unifying shades: Light and Medium.\n" +
                        "\n" +
                        "MEDICAL USES: oily, imperfection-prone skin with clogged pores\n" +
                        "SIDE-EFFECTS: ///\n" +
                        "INTERACTIONS: ///\n" +
                        "DOSES: ///\n",
                R.drawable.duounifiant));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Zinc oxide paste",
                "ZnO",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                35,
                "Zinc oxide paste is used to treat skin disorders and irritations. However, practitioners also advise the patients to use it as a diaper rash cream because it acts as a protection paste between the skin and the diaper.\n" +
                        "\n" +
                        "MEDICAL USES: o treat or prevent minor skin irritations such as burns, cuts, and diaper rash\n" +
                        "SIDE-EFFECTS: hives, difficult breathing, swelling of your face, lips, tongue, or throat\n" +
                        "INTERACTIONS: Carbamazepine, Ceftibuten, Cephalexin, Cinoxacin, Ciprofloxacin, Deferasirox, Deferiprone, Delafloxacin, Demeclocycline, Dolutegravir\n" +
                        "DOSES: ///\n",
                R.drawable.zincipasta));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Jomelop E",
                "essential oils and extracts of medicinal plants, olive oil",
                "Menta Padej, Kosovo",
                "OTC",
                0,
                40,
                "This salve, with its suitable medicinal composition, works very effectively for burns of the first degree of intensity, as immediately after being applied to the burned place, the pain subsides and the erythema (redness) disappears in a relatively short time. This salve showed great results in almost complete reduction, i.e. removal of scars and keloids caused by burns and other types of injuries.\n" +
                        "\n" +
                        "MEDICAL USES: first degree burn\n" +
                        "SIDE-EFFECTS: For external use only.\n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.jomelope));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Kalii permanganas",
                "KmNO4",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                40,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.kaliiperm));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Lemon cream",
                "N/A",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                50,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.lemoncream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Cream with collagen",
                "N/A",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                50,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.colagencream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Moisturizing cream",
                "N/A",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                50,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.hydracream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Galea night cream",
                "N/A",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                50,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.nightcream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Galea daily cream",
                "N/A",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                50,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.dailycream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Anti-wrinkle cream",
                "N/A",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                15,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.antiridcream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Golden Argan daily cream",
                "N/A",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                50,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.argandailycream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Golden Argan night cream",
                "N/A",
                "Galas, Bosnia and Herzegovina",
                "OTC",
                0,
                50,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.argannightcream));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Avene Cleanance cleansing gel",
                "N/A",
                "Pierre Fabre, France",
                "OTC",
                0,
                200,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.avenecleansinggel));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Dalsy syrup",
                "ibuprofen",
                "BGP Products Operations GmBH, Germany",
                "OTC",
                100,
                100,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.dalsy));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Snup nasal spray",
                "xylometazoline",
                "Hemofarm, Bosnia and Herzegovina",
                "OTC",
                0.1,
                10,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.snup));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Pantenole cream",
                "xylometazoline",
                "Galenika, Serbia",
                "OTC",
                0.5,
                30,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.pantenol));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Panatus forte",
                "butamirate",
                "KRKA, Slovenia",
                "OTC",
                50,
                10,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.panatusforte));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Nisita nasal ointment",
                "N/A",
                "N/A",
                "OTC",
                0,
                10,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.nisita));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Lysobact",
                "lysozyme, pyridoxine",
                "Bosnalijek, Bosnia and Herzegovina",
                "OTC",
                30,
                50,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.lysobact));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Viranto forte",
                "xylometazoline",
                "4U pharma, Switzerland",
                "OTC",
                0,
                100,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.virantoforte));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "BlokMAX",
                "ibuprofen",
                "ALKALOID Skopje, North Macedonia",
                "OTC",
                200,
                10,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.blokmax));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Trawelin",
                "cyanocobalamin, pyridoxine, thiamine",
                "Amsal, Bosnia and Herzegovina",
                "OTC",
                0,
                30,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.trawelin));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Betadine",
                "povidone iodine",
                "ALKALOID Skopje, North Macedonia",
                "OTC",
                100,
                20,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.betadine));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "PropolAID PropolGola FORTE Spray",
                "propolis, mint",
                "ESI Propolaid, Bosnia and Herzegovina",
                "OTC",
                0,
                20,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.propolgolaforte));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Vitamin D3",
                "vit. D3",
                "Zein Pharma, Germany",
                "OTC",
                2000,
                90,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.vitd3zein));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Lynase nasal spray",
                "cyanocobalamin, pyridoxine, thiamine",
                "Bosnalijek, Bosnia and Herzegovina",
                "OTC",
                0,
                30,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.lynase));
        Database.getInstance(this).drugsDAO().add(new DrugsDB(
                "Vitamin C + Zink",
                "vit. C, zink",
                "DoppleHerz Active, North Macedonia",
                "OTC",
                200,
                20,
                "\n" +
                        "\n" +
                        "MEDICAL USES: \n" +
                        "SIDE-EFFECTS: \n" +
                        "INTERACTIONS: \n" +
                        "DOSES: \n",
                R.drawable.vitcherz));
    }
}