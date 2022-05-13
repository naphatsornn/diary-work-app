#วิธีติดตั้งและรันโปรแกรม
Window : clone งาน6210451683จาก bitbucket โหลดลงเครื่อง -->เข้าโฟล์เดอร์ 6210451683 -> double click 6210451683.jar

Mac OS : clone งาน6210451683จาก bitbucket โหลดลงเครื่อง -->เข้าโฟล์เดอร์  6210451683 -> คลิกขวาเปิด 6210451683.jar

#วิธีติดตั้ง Font จากโฟลเดอร์ font
:  เข้าโฟล์เดอร์ Font -> double click baskervi --> click Install
เข้าโฟล์เดอร์ Font ->double click baskerville bload bt --> click Install
เข้าโฟล์เดอร์ Font ->double click baskerville bload font --> click Install
เข้าโฟล์เดอร์ Font ->double click baskervillebloadBT --> click Install
เข้าโฟล์เดอร์ Font ->double click baskervillebloadltalicBT --> click Install
เข้าโฟล์เดอร์ Font ->double click baskervilleBT --> click Install
เข้าโฟล์เดอร์ Font ->double click baskervilleltalicBT --> click Install
เข้าโฟล์เดอร์ Font ->double click HARLOWSI --> click Install
เข้าโฟล์เดอร์ Font ->double click HarlowSolidltalicltalic --> click Install
เข้าโฟล์เดอร์ Font ->double click Franklin Gothic Heavy Regular --> click Install
เข้าโฟล์เดอร์ Font ->double click Franklin Gothic Medium Regular --> click Install

#การวางโครงสร้างไฟล์
6210451683/6210451683/CSV
-category
-work

6210451683/6210451683
6210451683-jarfile

src/main/java/com/github/saacsos
FXRouter.java

src/main/java/diaryWork/controllers
-AddCategoryContronller.java -->เป็นหน้า สำหรับเพิ่มชื่อหมวดหมู่

-AddWorkController.java --> เป็นหน้าสำหรับให้ผู้ใช้เลือกประเภทงานเพื่อไปเพิ่มรายละเอียดงานนั้น

-CategoryController.java -->เป็นหน้าสำหรับแสดงจำนวนงานในแต่ละหมวดหมู่

-EditListController.java --> เป็นหน้าสำหรับการแก้ไขรายละเอียดงาน

-ForwardController.java --> เป็นหน้าสำหรับเพิ่มรายละเอียดงานประเภทงานส่งต่อ

-GeneralController.java --> เป็นหน้าสำหรับเพิ่มรายระเอียดงานของงานประเภทงานทั่วไป

-GuideController.java --> เป็นหน้าสำหรับแสดงคำแนะนำการใช้คร่าวๆให้แก่ผู้ใช้

-HomeController.java --> เป็นหน้าแรกของโปรแกรมเมื่อเปิดโปรแกรมขึ้นมา

-ListController.java --> เป็นหน้าสำหรับแสดงผลของงานทั้งหมด

-NameController.java --> เป็นหน้าแสดงข้อมูลผู้จัดทำ

-ProjectController.java --> เป็นหน้าสำหรับเพิ่มรายละเอียดงานของงานประเภทงานโครงการ

-ShowController.java --> เป็นหน้าสำหรับแสดงงานในหมวดหมู่ตามที่ผู้ใช้เลือก

-WeekController.java --> เป็นหน้าสำหรับเพิ่มรายละเอียดของงานประเภทงานประจำสัปดาห์

-WorkController.java --> เป็นหน้าสำหรับให้ผู้ใช้เลือกว่าจะไปหน้าแสดงตารางงานหรือเพิ่มงาน

src/main/java/diaryWork/models

-category.java  :เก็บ Class รูปแบบโครงสร้างของข้อมูล Category

-Forward.java :เก็บ Class รูปแบบโครงสร้างของข้อมูล ForwardWork

-General.java :เก็บ Class รูปแบบโครงสร้างของข้อมูล GeneralWork

-Item.java  เก็บ Class รูปแบบโครงสร้างของข้อมูล item ทุกประเภท

-Project.java :เก็บ Class รูปแบบโครงสร้างของข้อมูลProjectWork

-week.java :เก็บ Class รูปแบบโครงสร้างของข้อมูลWeekofdayWork


src/main/java/diaryWork/services

CategoryFile.java --> เขียนและอ่านไฟล์ของ Category

WorkFile.java --> เขียนและอ่านไฟล์ของ Work

src/main/resources/fxml
:เก็บไฟล์ fxml

addCategory.fxml --> หน้าซีนของหน้าเพิ่มหมวดหมู่

addWork.fxml --> หน้าซีนของหน้าเพิ่มงาน

category.fxml --> หน้าซีนของหน้าหมวดหมู่

editList.fxml --> หน้าาซีนของหน้าแก้ไขรายละเอียดงาน

forward.fxml --> หน้าซีนเพิ่มรายละเอียดของงานประเภทงานส่งต่อ

general.fxml --> หน้าซีนเพิ่มรายละเอียดของงานประเภทงานทั่วไป

guide.fxml -->หน้าซีนคำแนะนำของโปรแกรม

home.fxml --> หน้าซีนเมื่อเปิดโปรแกรมขึ้นมา

list.fxml --> หน้าซีนแสดงผลของงานทั้งหมด

name.fxml --> หน้าซีนแสดงข้อมูลผู้จัดทำ

project.fxml --> หน้าซีนเพิ่มรายละเอียดของงานประเภทงานโครงการ

show.fxml --> หน้าซีนสำหรับแสดงตารางานงานในหมวดหมู่ที่เลือก

week.fxml --> หน้าซีนเพิ่มรายละเอียดของงานประเภทงานประจำสัปดาห์

work.fxml --> หน้าซีนสำหรับให้ผู้ใช้เลือกว่าจะดูตารางแสดงงานทั้งหมดหรือเพิ่มงานลงในโปรกรม


src/main/resources/photo
:เก็บไฟล์รูป

Admin.jpg : รูปผู้จัดทำ
BGAddCategory.jpg :เป็นรูปพื้นหลัง

BGAddWork.jpg :เป็นรูปพื้นหลัง

BGAdmin.jpg :เป็นรูปพื้นหลัง

BGEdit.jpg :เป็นรูปพื้นหลัง

BGGuide.jpg :เป็นรูปพื้นหลัง

BGHome.jpg :เป็นรูปพื้นหลัง

List.jpg :เป็นรูปพื้นหลัง

BGShow.jpg :เป็นรูปพื้นหลัง

BGWork.jpg :เป็นรูปพื้นหลัง

Work.jpg :เป็นรูปพื้นหลัง

src/main/resources/design
: css สำหรับตกแต่งปุ่มและพื้นหลัง

#สรุปสิ่งที่พัฒนาในแต่ละสัปดาห์
สัปดาห์ที่1
- สร้าง repository ในbitbucket สำหรับส่งโครงงาน
  -เขียนไฟล์ อ่านไฟล์
  -สร้างหน้า fxml
  -คิดรูปแบบ GUI

สัปดาห์ที่2
-สร้าง arraylist
-เพิ่มclass ใน controllers
-เพิ่มหน้า fxml
-เชื่อมปุ่มกับหน้าต่างๆ
-แต่งbutton,combobox,lable ,datepickerในscence builder

สัปดาห์ที่3
-เพิ่มหน้าสำรับ addงานแต่ละประเภท
-สามารถแสดงผลใน tableview ได้
-อ่านเขียนไฟล์เพิ่ม

สัปดาห์ที่4
-สร้าง alert เตือนเมื่อเพิ่มชื่องานซ้ำและสำหรับ confirm
-แก้ไขหน้า scene
-แก้ไขการแสดงผลในหน้า List


สัปดาห์ที่5
-เรียงลำดับความสำคัญ
-ใช้ polymorph
-ตกแต่งเพิ่มเติม

สัปดาห์ที่6
-เลือกสถานะ และ  วันที่เพื่อดูงาน
-อ่านเขียนไฟล์สำหรับการแก้ไขงาน,นับจำนวนหมวดหมู่,เพิ่มหมวดหมู่
-ใช้ css ตกแต่งปุ่มและพื้นหลัง 