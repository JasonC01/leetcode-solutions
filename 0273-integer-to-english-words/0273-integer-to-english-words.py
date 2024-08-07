class Solution(object):
    


    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        d = {0: "Zero",
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine",
        10: "Ten",
        11: "Eleven",
        12: "Twelve",
        13: "Thirteen",
        14: "Fourteen",
        15: "Fifteen",
        16: "Sixteen",
        17: "Seventeen",
        18: "Eighteen",
        19: "Nineteen",
        20: "Twenty",
        30: "Thirty",
        40: "Forty",
        50: "Fifty",
        60: "Sixty",
        70: "Seventy",
        80: "Eighty",
        90: "Ninety",
        100: "Hundred",
        1000: "Thousand",
        1000000: "Million",
        1000000000: "Billion"
        }

        if num <= 20:
            return d.get(num)

        bil = math.floor(num / 1000000000)
        mil = math.floor(num / 1000000)
        thousands = math.floor(num / 1000)
        hundreds = math.floor(num / 100)
        tens = math.floor(num / 10)
        
        if bil > 0:
            if num % 1000000000 > 0:
                return d.get(bil) + ' Billion ' + self.numberToWords(num % 1000000000)
            return d.get(bil) + ' Billion'

        if mil > 0:
            if num % 1000000 > 0:
                return self.numberToWords(mil) + ' Million ' + self.numberToWords(num % 1000000)
            return self.numberToWords(mil) + ' Million' 

        if thousands > 0:
            if num % 1000 > 0:
                return self.numberToWords(thousands) + ' Thousand ' + self.numberToWords(num % 1000)
            return self.numberToWords(thousands) + ' Thousand' 

        if hundreds > 0:
            if num % 100 > 0:
                return self.numberToWords(hundreds) + ' Hundred ' + self.numberToWords(num % 100)
            return self.numberToWords(hundreds) + ' Hundred'
        if tens > 0:
            if num % 10 > 0:
                return d.get(tens * 10) + ' ' + self.numberToWords(num % 10)
            return d.get(tens * 10)


            