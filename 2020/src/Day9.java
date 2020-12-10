import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {
    private final static List<Long> inputs = Arrays.asList(23L, 3L, 36L, 14L, 50L, 8L, 2L, 44L, 30L, 37L, 20L, 5L, 34L, 41L, 31L, 39L, 28L, 24L, 49L, 42L, 22L, 4L, 45L, 46L, 32L, 6L, 35L, 7L, 26L, 15L, 21L, 8L, 9L, 12L, 25L, 10L, 11L, 13L, 14L, 16L, 17L, 57L, 18L, 64L, 19L, 20L, 22L, 33L, 27L, 23L, 24L, 28L, 29L, 30L, 38L, 31L, 37L, 35L, 21L, 26L, 44L, 25L, 32L, 34L, 36L, 69L, 40L, 51L, 39L, 43L, 41L, 45L, 46L, 63L, 49L, 54L, 47L, 66L, 64L, 55L, 52L, 65L, 53L, 57L, 59L, 83L, 61L, 92L, 70L, 97L, 79L, 80L, 82L, 84L, 86L, 87L, 91L, 93L, 96L, 101L, 99L, 148L, 105L, 107L, 109L, 110L, 112L, 114L, 116L, 166L, 204L, 191L, 196L, 149L, 159L, 161L, 198L, 240L, 170L, 173L, 178L, 190L, 219L, 314L, 200L, 206L, 222L, 217L, 216L, 223L, 224L, 428L, 412L, 265L, 319L, 404L, 349L, 357L, 308L, 446L, 331L, 670L, 343L, 348L, 384L, 368L, 407L, 514L, 406L, 737L, 628L, 433L, 439L, 440L, 584L, 667L, 596L, 741L, 749L, 639L, 918L, 651L, 656L, 674L, 727L, 679L, 691L, 1040L, 781L, 1342L, 775L, 813L, 839L, 1023L, 1406L, 873L, 1455L, 1131L, 1114L, 1420L, 1235L, 1247L, 1440L, 1347L, 1290L, 1307L, 2366L, 1330L, 1353L, 1370L, 1454L, 1466L, 2071L, 1556L, 2467L, 1588L, 1652L, 2701L, 1896L, 2723L, 2895L, 2245L, 2444L, 3814L, 2577L, 2617L, 2537L, 2637L, 2597L, 2620L, 2807L, 2700L, 5140L, 3208L, 4289L, 5214L, 3054L, 5168L, 3144L, 6198L, 5498L, 4353L, 4141L, 4513L, 4689L, 4782L, 4822L, 9511L, 5174L, 9604L, 5134L, 5681L, 6761L, 7096L, 5320L, 7561L, 5844L, 7833L, 6262L, 7343L, 14386L, 7195L, 7285L, 8318L, 10951L, 8866L, 8494L, 8654L, 10978L, 11878L, 15627L, 11895L, 14538L, 15513L, 10454L, 12876L, 13129L, 12106L, 14480L, 11164L, 13039L, 13547L, 15837L, 15689L, 27356L, 15779L, 15603L, 24992L, 19269L, 21742L, 17148L, 19472L, 36417L, 31628L, 21618L, 28503L, 22349L, 24293L, 24203L, 22560L, 42959L, 23270L, 32927L, 24711L, 38539L, 60710L, 35161L, 31292L, 31382L, 32751L, 34872L, 35075L, 41351L, 45619L, 36620L, 43765L, 41090L, 54188L, 47473L, 43967L, 44909L, 99097L, 67162L, 85318L, 57432L, 47981L, 54562L, 56003L, 67912L, 62674L, 85999L, 79363L, 64043L, 92890L, 67623L, 100663L, 71695L, 80385L, 77710L, 98155L, 91440L, 127698L, 92382L, 88876L, 131955L, 99471L, 167825L, 102543L, 110565L, 120046L, 103984L, 117236L, 118677L, 126717L, 151550L, 194946L, 167094L, 131666L, 148008L, 139318L, 149405L, 202947L, 158095L, 169150L, 226188L, 257995L, 202014L, 188347L, 199441L, 263621L, 321663L, 206527L, 229242L, 227801L, 224030L, 221220L, 270984L, 245394L, 274725L, 279674L, 281071L, 287326L, 288723L, 297413L, 379315L, 307500L, 357536L, 327245L, 390370L, 387788L, 423471L, 390361L, 572138L, 405968L, 427747L, 619076L, 495014L, 445250L, 449021L, 502291L, 466614L, 516378L, 520119L, 562051L, 560745L, 568397L, 576049L, 586136L, 604913L, 634745L, 776266L, 717615L, 717606L, 778149L, 793756L, 856975L, 851218L, 876768L, 833715L, 872997L, 894271L, 911864L, 1184229L, 1165658L, 1338894L, 982992L, 1146881L, 1130448L, 1279657L, 1383062L, 1144446L, 1568824L, 1191049L, 1352360L, 1412894L, 2003856L, 1435221L, 2038655L, 1571905L, 2574111L, 1690690L, 2113440L, 3682264L, 1706712L, 1767268L, 1806135L, 2058745L, 2127438L, 2129873L, 2277329L, 2174041L, 3318487L, 3140729L, 2692551L, 2496806L, 3043050L, 2543409L, 2603943L, 3158495L, 5009177L, 3007126L, 3125911L, 4240878L, 3473980L, 3397402L, 4336074L, 3512847L, 3573403L, 3880753L, 3826013L, 3864880L, 5332536L, 4257311L, 5790176L, 4451370L, 4670847L, 5040215L, 5100749L, 5147352L, 5586459L, 7677973L, 5550535L, 5611069L, 6133037L, 7299993L, 8437617L, 6699314L, 9589847L, 10711818L, 7223415L, 7086250L, 7706766L, 7399416L, 7690893L, 8083324L, 8122191L, 8928158L, 8708681L, 9122217L, 9491585L, 9711062L, 10140964L, 10248101L, 10697887L, 14708676L, 11161604L, 14539227L, 15306739L, 15828957L, 14406080L, 13785564L, 13922729L, 14930181L, 14309665L, 17205541L, 24654181L, 15090309L, 15482740L, 16813110L, 17011482L, 24212526L, 17636839L, 19202647L, 24547044L, 19632549L, 19959163L, 20389065L, 31550709L, 21859491L, 24947168L, 25084333L, 28095229L, 29229468L, 28191644L, 31941663L, 27708293L, 32727148L, 29239846L, 40136921L, 41418067L, 47424403L, 37596002L, 35115289L, 33824592L, 34648321L, 39591712L, 36839486L, 38835196L, 40021614L, 40348228L, 41818654L, 45336233L, 46806659L, 56948139L, 60918792L, 52792626L, 55803522L, 55899937L, 57431490L, 41682220L, 67842437L, 84927945L, 78426908L, 68472913L, 109740765L, 68939881L, 72244323L, 76861100L, 70664078L, 71487807L, 82175719L, 75674682L, 180404843L, 80369842L, 82030448L, 87018453L, 160602627L, 113926543L, 136315350L, 94474846L, 97485742L, 124372850L, 97582157L, 112346298L, 109524657L, 144147595L, 139603959L, 226272841L, 154274771L, 140427688L, 141184204L, 142151885L, 157850401L, 242633075L, 238766361L, 156044524L, 162400290L, 167388295L, 169048901L, 207010399L, 196543110L, 191960588L, 241729752L, 206821144L, 251760513L, 195067899L, 303584494L, 406035284L, 266621069L, 354360878L, 280788163L, 280031647L, 281611892L, 282579573L, 308572499L, 283336089L, 449000187L, 436797651L, 318444814L, 323432819L, 325093425L, 489400717L, 375870045L, 361009489L, 387028487L, 664593983L, 398781732L, 524309325L, 401889043L, 475856062L, 605125072L, 546652716L, 547409232L, 562400055L, 564191465L, 891289760L, 945434448L, 606768908L, 659206134L, 1096169625L, 930201727L, 641877633L, 1532967276L, 794300876L, 648526244L, 686102914L, 748037976L, 1123908021L, 907662205L, 785810219L, 1445016353L, 1008657951L, 877745105L, 949298275L, 1022508778L, 1094061948L, 1109052771L, 1109809287L, 1756695927L, 1265975042L, 1248646541L, 1255295152L, 1290403877L, 1578727971L, 1334629158L, 1480403790L, 1327980547L, 1396564220L, 1434140890L, 1772434265L, 2486390176L, 1957956226L, 1663555324L, 1894862990L, 1735108494L, 1827043380L, 1886403056L, 1900253883L, 1971807053L, 2116570726L, 2203114719L, 2218862058L, 2358455828L, 2503941693L, 2514621583L, 2539050418L, 2618384424L, 3465131027L, 3012868861L, 4347498019L, 2808384337L, 2724544767L, 2830705110L, 4747977355L, 3398663818L, 3490598704L, 3549958380L, 3706915547L, 3562151874L, 4030158099L, 6562827241L, 3786656939L, 4802512163L, 4510857471L, 4319685445L, 4421976777L, 5122326117L, 5449089534L, 5042992111L, 5053672001L, 5157434842L, 5342929191L, 5532929104L, 5555249877L, 8349843544L, 7810284149L, 6123208585L, 6321303814L, 7197514251L, 6889262522L, 7112110254L, 7256873927L, 8864350389L, 14419600266L, 7816815038L, 8106342384L, 9668292313L, 16166658582L, 13228668501L, 8741662222L, 10677575994L, 10096664112L, 14987558974L, 10200426953L, 21970330723L, 10500364033L, 10875858295L, 11656137689L, 11678458462L, 12444512399L, 15853772476L, 13012471107L, 13578177741L, 19419238216L, 15073688965L, 14368984181L, 23512835140L, 15923157422L, 16558477260L, 16848004606L, 24595434698L, 18409954535L, 18838326334L, 18942089175L, 20972522407L, 20297091065L, 21076285248L, 21376222328L, 21878885415L, 22156501722L, 22178822495L, 39366607616L, 27518201364L, 27381455288L, 28935628529L, 31988132276L, 39716329281L, 43129024129L, 29442673146L, 30292141603L, 30927461441L, 59863089970L, 35686330940L, 45494105789L, 37248280869L, 37352043710L, 37780415509L, 49869550616L, 39239180240L, 47678546353L, 41373376313L, 84926827222L, 43532724050L, 44035387137L, 44335324217L, 49560277783L, 74327528740L, 54899656652L, 59369587564L, 58378301675L, 61430805422L, 80612556553L, 138990858228L, 67540422472L, 61219603044L, 66613792381L, 73466746449L, 73038374650L, 74600324579L, 75028696378L, 75132459219L, 77019595749L, 82771904290L, 155810278940L, 92013870570L, 84906100363L, 87568111187L, 87868048267L, 93595664920L, 93895602000L, 133969912143L, 135819927623L, 113277958327L, 117747889239L, 119597904719L, 249097885950L, 127833395425L, 142569118850L, 134257977694L, 139652167031L, 140080538830L, 146505121099L, 148067071028L, 149629020957L, 275900466453L, 152152054968L, 159791500039L, 167678004653L, 211343554159L, 172474211550L, 178801702363L, 207173560327L, 181463713187L, 347254099157L, 211643491239L, 231025847566L, 247535936021L, 257400056270L, 237345793958L, 301781075925L, 262091373119L, 267485562456L, 282325048722L, 273910144725L, 279732705861L, 413990683555L, 417114583413L, 356802581284L, 309420520996L, 319830059621L, 327469504692L, 366965060366L, 780955743921L, 390445193602L, 539126869883L, 866596374575L, 591745569718L, 418809507145L, 1097622222141L, 442669338805L, 468371641524L, 484881729979L, 494745850228L, 499437167077L, 541395707181L, 529576935575L, 549810611178L, 553642850586L, 1280587058130L, 804166371224L, 856660022360L, 629250580617L, 809634399171L, 1018182252702L, 647299564313L, 694434565058L, 1286180134776L, 809254700747L, 833114532407L, 2383802356917L, 887181148669L, 861478845950L, 1014458665554L, 927551068784L, 1391055781525L, 953253371503L, 979627580207L, 994183017305L, 1040832874258L, 1070972642756L, 1433416951841L, 1103453461764L, 1200942414899L, 1691347519893L, 1276550144930L, 3584744771816L, 1438505281364L, 1456933963484L, 1534480712982L, 2119294667183L, 1503689265805L, 1642369233154L, 1880804440287L, 1694593378357L, 1964932307714L, 1990634610433L, 2318606850309L, 2431888655783L, 1907178648991L, 3389579493065L, 1932880951710L, 2020460454465L, 2451116980789L, 2111805517014L, 2304395876663L, 2380003606694L, 2477492559829L, 2639447696263L, 4684399483357L, 2715055426294L, 3364112612475L, 3345683930355L, 4339067304774L, 3038169978787L, 5515662538616L, 4736284532446L, 3336962611511L, 3992609957301L, 3601772027348L, 3840059600701L, 6965884639823L, 3953341406175L, 3927639103456L, 4018984166005L, 5116940256092L, 5622232481813L, 4562922497803L, 4416201393677L, 6682646541866L, 4781888436492L, 8553832517403L, 5192547986123L, 5354503122557L, 6383853909142L, 5753225405081L, 8164694525151L, 6375132590298L, 8755268698451L, 6639942006135L, 6938734638859L, 7355946777516L, 7264601714967L, 10893523743279L, 7441831628049L, 8709527539948L, 9044579359548L, 7880980509631L, 7946623269461L, 9608749379800L, 12435871946947L, 8979123891480L, 15139122607593L, 9198089830169L, 9974436422615L, 11738357031699L, 13109172182597L, 10547051108680L, 20047906821456L, 12128357995379L, 12393167411216L, 17799848057999L, 13731079367814L, 15648262178807L, 13578676644994L, 14203336353826L, 20382495216408L, 17489729889431L, 19172526252784L, 15322812137680L, 16860104401111L, 20274147920847L, 24301936029160L, 19684980301160L, 22675409104059L, 22940218519896L, 18177213721649L, 36908011222567L, 19745140938849L, 23866715027078L, 23656223291277L, 24125727753674L, 43551695328238L, 25707034640373L, 24521525406595L, 25971844056210L, 27309756012808L, 35393403117656L, 27782012998820L, 28901488782674L, 32812542027111L, 37872225105839L, 32182916538791L, 33500025859329L, 35007792438840L, 35037318122760L, 37862194022809L, 42043928748727L, 41833437012926L, 37922354660498L, 52303538405415L, 42302941475323L, 43401364230126L, 43870868692523L, 47522938318355L, 47781951044951L, 48647253160269L, 86173810167846L, 59492672551599L, 60979636495050L, 53281600069018L);
    private final static List<Long> ainputs = Arrays.asList(35L, 20L, 15L, 25L, 47L, 40L, 62L, 55L, 65L, 95L, 102L, 117L, 150L, 182L, 127L, 219L, 299L, 277L, 309L, 576L);

    public static void main(String[] args) {
        int offset = 25;
        List<Long> lastChars = new ArrayList<>();

        for (int i = 0; i < offset; i++) lastChars.add(inputs.get(i));

        long target = 0;
        for (int i = offset; i < inputs.size(); i++) {
            long actual = inputs.get(i);
            boolean isAnyMatch = lastChars.stream().anyMatch(x -> lastChars.contains(actual - x));
            if (isAnyMatch) {
                lastChars.remove(0);
                lastChars.add(actual);
            } else {
                target = actual;
                System.out.println("Pt1: " + target);
                break;
            }
        }

        long lastNum = inputs.get(0);
        for (int i = 1; i < inputs.size(); i++) {
            long smallest = Long.MAX_VALUE;
            long biggest = Long.MIN_VALUE;
            if (lastNum + inputs.get(i) < target) {
                long sum = lastNum + inputs.get(i);
                for (int y = i + 1; y < inputs.size(); y++) {
                    long currNum = inputs.get(y);
                    if (sum + currNum == target) {
                        //found
                        System.out.println("Pt2: " + (smallest + biggest));
                    } else if (sum + currNum > target) {
                        break;
                    } else {
                        sum += currNum;
                        if (lastNum < smallest) smallest = lastNum;
                        if (lastNum > biggest) biggest = lastNum;
                        if (currNum < smallest) smallest = currNum;
                        if (currNum > biggest) biggest = currNum;
                    }
                }
            }
            lastNum = inputs.get(i);
        }
    }
}