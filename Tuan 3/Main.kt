import java.util.*

// Abstract class NhanVien
abstract class NhanVien(
    var MaNV: String,
    var HoTen: String,
    protected var LuongCoBan: Double
) {
    abstract fun tinhLuong(): Double
    open fun nhap() {
        val scanner = Scanner(System.`in`)
        print("Enter Employee ID: ")
        this.MaNV = scanner.nextLine()
        print("Enter Full Name: ")
        this.HoTen = scanner.nextLine()
        print("Enter Base Salary: ")
        this.LuongCoBan = scanner.nextDouble()
    }

    open fun xuat() {
        println("Employee ID: $MaNV")
        println("Full Name: $HoTen")
        println("Base Salary: $LuongCoBan")
    }
}

// Class NhanVienVanPhong
class NhanVienVanPhong(
    MaNV: String,
    HoTen: String,
    LuongCoBan: Double,
    private var SoNgayLamViec: Int
) : NhanVien(MaNV, HoTen, LuongCoBan) {

    override fun tinhLuong(): Double {
        return LuongCoBan + SoNgayLamViec * 100
    }
    override fun nhap() {
        val scanner = Scanner(System.`in`)
        print("Enter Employee ID: ")
        this.MaNV = scanner.nextLine()
        print("Enter Full Name: ")
        this.HoTen = scanner.nextLine()
        print("Enter Base Salary: ")
        this.LuongCoBan = scanner.nextDouble()
        print("Enter Number of Working Days: ")
        this.SoNgayLamViec =scanner.nextInt()
    }
    override fun xuat() {
        super.xuat()
        println("Number of Working Days: $SoNgayLamViec")
        println("Salary: ${tinhLuong()}")
    }
}

// Class NhanVienSanXuat
class NhanVienSanXuat(
    MaNV: String,
    HoTen: String,
    LuongCoBan: Double,
    private var SoSanPham: Int
) : NhanVien(MaNV, HoTen, LuongCoBan) {

    override fun tinhLuong(): Double {
        return LuongCoBan + SoSanPham * 50
    }

    open override fun nhap() {
        val scanner = Scanner(System.`in`)
        print("Enter Employee ID: ")
        this.MaNV = scanner.nextLine()
        print("Enter Full Name: ")
        this.HoTen = scanner.nextLine()
        print("Enter Base Salary: ")
        this.LuongCoBan = scanner.nextDouble()
        print("Enter Number of Products Produced: ")
        this.SoSanPham = scanner.nextInt()
    }
    override fun xuat() {
        super.xuat()
        println("Number of Products Produced: $SoSanPham")
        println("Salary: ${tinhLuong()}")
    }
}

// Class CongTy
class CongTy {
    private val dsNhanVien = mutableListOf<NhanVien>()

    fun themNhanVien(nv: NhanVien) {
        dsNhanVien.add(nv)
    }

    fun xuatThongTinNhanVien() {
        for (nv in dsNhanVien) {
            nv.xuat()
            println("-------------------")
        }
    }

    fun timKiemNhanVien(maNV: String): NhanVien? {
        return dsNhanVien.find { it.MaNV == maNV }
    }

    fun tongLuongNhanVienVanPhong(): Double {
        return dsNhanVien.filterIsInstance<NhanVienVanPhong>().sumOf { it.tinhLuong() }
    }
}
fun main() {
    val congTy = CongTy()

    // Nhập thông tin nhân viên văn phòng
    println("Enter Office Employee 1:")
    val nvvp1 = NhanVienVanPhong("", "", 0.0,0)
    nvvp1.nhap()
    congTy.themNhanVien(nvvp1)

    println("Enter Office Employee 2:")
    val nvvp2 = NhanVienVanPhong("", "", 0.0,0)
    nvvp2.nhap()
    congTy.themNhanVien(nvvp2)

    // Nhập thông tin nhân viên sản xuất
    println("Enter Production Employee 1:")
    val nvsx1 = NhanVienSanXuat("", "", 0.0,0)
    nvsx1.nhap()
    congTy.themNhanVien(nvsx1)

    println("Enter Production Employee 2:")
    val nvsx2 = NhanVienSanXuat("", "", 0.0,0)
    nvsx2.nhap()
    congTy.themNhanVien(nvsx2)

    // Hiển thị thông tin nhân viên
    println("\nEmployee Information:")
    congTy.xuatThongTinNhanVien()

    // Tìm kiếm nhân viên theo mã
    val scanner = Scanner(System.`in`)
    print("\nEnter Employee ID to search: ")
    val maNV = scanner.nextLine()
    val foundEmployee = congTy.timKiemNhanVien(maNV)
    if (foundEmployee != null) {
        println("Employee found:")
        foundEmployee.xuat()
    } else {
        println("Employee not found")
    }

    // Tính tổng lương nhân viên văn phòng
    val totalSalary = congTy.tongLuongNhanVienVanPhong()
    println("\nTotal Salary of Office Employees: $totalSalary")
}

