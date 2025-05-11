<!DOCTYPE html>
<html>
<head>
    <title>Bank Dashboard</title>
    <style>
        body {
            background: #f0f0f0;
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 40px;
        }
        h2 {
            margin-bottom: 40px;
        }
        .row {
            display: flex;
            justify-content: center;
            gap: 40px;
            flex-wrap: wrap;
            margin-bottom: 40px;
        }
        .block {
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 300px;
        }
        h3 {
            margin-bottom: 15px;
        }
        input[type="text"], input[type="number"] {
            width: 90%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 6px;
            border: 1px solid #ccc;
        }
        button {
            width: 95%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            margin-top: 10px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h2>Bank Dashboard</h2>

    <!-- Deposit & Withdraw -->
    <div class="row">
        <div class="block">
            <h3>Deposit</h3>
            <form action="deposit">
                <input type="text" name="pin" placeholder="Enter PIN" required><br>
                <input type="number" name="amount" step="0.01" placeholder="Amount" required><br>
                <button type="submit">Deposit</button>
            </form>
        </div>

        <div class="block">
            <h3>Withdraw</h3>
            <form action="withdraw" method="get">
                <input type="text" name="pin" placeholder="Enter PIN" required><br>
                <input type="number" name="amount" step="0.01" placeholder="Amount" required><br>
                <button type="submit">Withdraw</button>
            </form>
        </div>
    </div>

    <!-- Transfer -->
    <div class="row" style="justify-content: center;">
        <div class="block">
            <h3>Transfer</h3>
            <form action="transfer" method="get">
                <input type="text" name="senderPin" placeholder="Your PIN" required><br>
                <input type="text" name="receiverPin" placeholder="Receiver's PIN" required><br>
                <input type="number" name="amount" step="0.01" placeholder="Amount to Transfer" required><br>
                <button type="submit">Transfer</button>
            </form>
        </div>
    </div>

</body>
</html>
