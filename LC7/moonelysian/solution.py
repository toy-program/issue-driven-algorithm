  def reverse(self, x: int) -> int:
        reversedInt = int(str(abs(x))[::-1])
        if (x < 0):
            reversedInt *= -1
        return reversedInt if -(2**31)-1 < reversedInt < 2**31 else 0